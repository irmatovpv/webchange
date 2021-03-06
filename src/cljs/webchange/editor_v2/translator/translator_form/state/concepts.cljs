(ns webchange.editor-v2.translator.translator-form.state.concepts
  (:require
    [re-frame.core :as re-frame]
    [webchange.editor-v2.concepts.utils :refer [resource-type?]]
    [webchange.editor-v2.creation-progress.translation-progress.validate-action :as validate]
    [webchange.editor-v2.dialog.dialog-form.state.concepts-utils :as concepts-utils]
    [webchange.editor-v2.history.state :as history]
    [webchange.editor-v2.subs :as editor-subs]
    [webchange.editor-v2.translator.translator-form.state.db :refer [path-to-db]]
    [webchange.editor-v2.translator.translator-form.state.concepts-utils :refer [get-concepts-audio-assets]]
    [webchange.editor-v2.translator.translator-form.state.scene :as translator-form.scene]
    [webchange.editor-v2.translator.translator-form.state.window-confirmation :as confirm]))

;; Subs

(re-frame/reg-sub
  ::scene-versions
  (fn [db]
    (get-in db [:editor :scene-versions])))

(defn course-datasets
  [db]
  (get-in db [:editor :course-datasets]))

(re-frame/reg-sub
  ::course-datasets
  course-datasets)

(defn- get-concept-scheme
  [course-datasets]
  (some (fn [dataset]
          (and (= "concepts" (:name dataset))
               dataset))
        course-datasets))

(defn concept-scheme
  [db]
  (let [course-datasets (course-datasets db)]
    (get-concept-scheme course-datasets)))

(re-frame/reg-sub
  ::concept-scheme
  (fn []
    [(re-frame/subscribe [::course-datasets])])
  (fn [[course-datasets]]
    (get-concept-scheme course-datasets)))

(defn- get-concept-by-id
  [db concept-id]
  (get-in db (path-to-db [:concepts :data concept-id])))

(defn- current-concept-id
  [db]
  (get-in db (path-to-db [:concepts :current-concept])))

(defn current-concept
  [db]
  (->> (current-concept-id db)
       (get-concept-by-id db)))

(re-frame/reg-sub
  ::current-concept
  current-concept)

(defn edited-concepts
  [db]
  (get-in db (path-to-db [:concepts :edited-concepts])))

(re-frame/reg-sub
  ::edited-concepts
  edited-concepts)

(re-frame/reg-sub
  ::current-concept-data
  (fn []
    [(re-frame/subscribe [::current-concept])])
  (fn [[current-concept]]
    (:data current-concept)))

(defn concepts-data
  [db]
  (get-in db (path-to-db [:concepts :data])))

(defn current-dataset-concept
  [db]
  (get-in db (path-to-db [:current-dataset-concept])))

(re-frame/reg-sub
  ::concepts-data
  concepts-data)

(defn- get-concepts-list
  [concepts-data]
  (->> concepts-data (vals) (sort-by :name)))

(defn concepts-list
  [db]
  (-> db concepts-data get-concepts-list))

(defn validate-concepts
  [concepts-list actions-vars]
  (map (fn [concept]
         (let [concept-complete? (every? (fn [field-name]
                                           (let [field-data (get-in concept [:data (keyword field-name)])]
                                             (if (resource-type? (:type field-data))
                                               (some? field-data)
                                               (validate/validate-phrase-action (get-in field-data [:data 0])))))
                                         actions-vars)]
           (assoc concept :complete? concept-complete?)))
       concepts-list))

(re-frame/reg-sub
  ::concepts-list
  (fn []
    [(re-frame/subscribe [::concepts-data])
     (re-frame/subscribe [::concepts-utils/actions-vars])])
  (fn [[concepts-data actions-vars]]
    (-> (get-concepts-list concepts-data)
        (validate-concepts actions-vars))))

(defn concepts-audios
  [db]
  (let [scheme (concept-scheme db)
        list (concepts-list db)
        scene-id (translator-form.scene/scene-id db)]
    (get-concepts-audio-assets scheme list scene-id)))

;; Events

(re-frame/reg-event-fx
  ::init-state
  (fn [{:keys [db]} [_]]
    (let [concepts (editor-subs/course-dataset-items db)
          dataset-concept (editor-subs/dataset-concept db)
          current-concept (->> concepts (vals) (sort-by :name) (first))]
      {:db         (-> db
                       (assoc-in (path-to-db [:concepts :data]) concepts)
                       (assoc-in (path-to-db [:current-dataset-concept]) dataset-concept))
       :dispatch-n (list [::set-current-concept (:id current-concept)]
                         [::set-edited-concepts []])})))

(re-frame/reg-event-fx
  ::set-current-concept
  (fn [{:keys [db]} [_ concept-id]]
    {:db (assoc-in db (path-to-db [:concepts :current-concept]) concept-id)}))

(re-frame/reg-event-fx
  ::reset-current-concept
  (fn [{:keys [_]} [_]]
    {:dispatch-n (list [::set-current-concept nil])}))

(re-frame/reg-event-fx
  ::set-edited-concepts
  (fn [{:keys [db]} [_ edited-concepts]]
    {:db (assoc-in db (path-to-db [:concepts :edited-concepts]) edited-concepts)}))

(re-frame/reg-event-fx
  ::add-edited-concepts
  (fn [{:keys [db]} [_ concept-id]]
    (let [current-list (edited-concepts db)
          updated-list (-> current-list
                           (conj concept-id)
                           (distinct))]
      {:dispatch-n       (list [::set-edited-concepts updated-list])
       :set-before-leave confirm/unsaved-changes-message})))

(re-frame/reg-event-fx
  ::update-current-concept
  (fn [{:keys [db]} [_ action-path data-patch]]
    (let [concept-id (current-concept-id db)]
      {:dispatch [::update-concept concept-id action-path data-patch]})))

(re-frame/reg-event-fx
  ::update-concept
  (fn [{:keys [db]} [_ concept-id action-path data-patch {:keys [suppress-history?]}]]
    (let [concept (get-concept-by-id db concept-id)
          action-data (get-in concept (concat [:data] action-path))
          updated-data (merge action-data data-patch)]
      {:db         (assoc-in db (path-to-db (concat [:concepts :data] [concept-id :data] action-path)) updated-data)
       :dispatch-n (->> (list [::add-edited-concepts concept-id]
                              (when-not suppress-history?
                                [::history/add-history-event {:type       :concept-action
                                                              :concept-id concept-id
                                                              :path       action-path
                                                              :from       (->> data-patch (keys) (select-keys action-data))
                                                              :to         data-patch}]))
                        (remove nil?))})))
