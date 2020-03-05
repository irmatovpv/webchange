(ns webchange.editor-v2.views
  (:require
    [reagent.core :as r]
    [webchange.editor-v2.fix-lodash]
    [webchange.editor-v2.views-data :refer [data get-scenes-options]]
    [webchange.editor-v2.views-diagram :refer [diagram]]
    [webchange.editor-v2.views-scene :refer [scene]]
    [webchange.ui.theme :refer [with-mui-theme]]
    [webchange.editor-v2.translator.views-modal :refer [translator-modal]]
    [cljs-react-material-ui.reagent :as ui]
    [cljs-react-material-ui.icons :as ic]
    [re-frame.core :as re-frame]
    [webchange.subs :as subs]
    [webchange.editor-v2.subs :as editor-subs]
    [webchange.routes :refer [redirect-to]]
    [webchange.editor-v2.concepts.views :refer [add-dataset-item-form edit-dataset-item-form delete-dataset-item-modal]]
    [webchange.editor-v2.concepts.events :as concepts-events]))

(defn modal-windows
  []
  [:div
   [translator-modal]
   [delete-dataset-item-modal]])

(defn- concepts
  []
  (let [course @(re-frame/subscribe [::subs/current-course])
        concepts (->> @(re-frame/subscribe [::editor-subs/course-dataset-items]) (vals) (sort-by :name))]
    [ui/paper
     [ui/typography {:variant "h6"} "Concepts"]
     [ui/list
      (for [concept concepts]
        ^{:key (:id concept)}
        [ui/list-item
         [ui/list-item-text {:primary (:name concept)}]
         [ui/list-item-secondary-action
          [ui/icon-button {:on-click #(redirect-to :course-editor-v2-concept :course-id course :concept-id (:id concept)) :aria-label "Edit"}
           [ic/edit]]
          [ui/icon-button {:on-click #(re-frame/dispatch [::concepts-events/open-delete-dataset-item-modal concept]) :aria-label "Delete"}
           [ic/delete]]]])
      [ui/list-item {:button true :on-click #(redirect-to :course-editor-v2-add-concept :course-id course)}
       [ui/list-item-avatar [ui/avatar [ic/add]]]
       [ui/list-item-text "Add new"]]]
     ]))

(defn- scenes
  []
  (let [course @(re-frame/subscribe [::subs/current-course])
        scenes @(re-frame/subscribe [::subs/course-scenes])
        scenes-options (get-scenes-options scenes)]
    [ui/paper
     [ui/typography {:variant "h6"} "Scenes"]
     [ui/list
      (for [scene scenes-options]
        ^{:key (:value scene)}
        [ui/list-item
         [ui/list-item-text {:primary (:text scene)}]
         [ui/list-item-secondary-action
          [ui/icon-button {:on-click #(redirect-to :course-editor-v2-scene :id course :scene-id (:value scene)) :aria-label "Edit"}
           [ic/edit]]]])]
    ]))

(defn- lessons
  []
  )

(defn add-concept-view
  [course-id]
  [with-mui-theme "dark"
   [:div.editor-v2 {}
    [:div.page
     [ui/app-bar {:position "static"}
      [ui/toolbar
       [ui/typography {:variant "h4"} "Concept"]]]
     [ui/paper
      [add-dataset-item-form course-id]]
     ]]])

(defn concept-view
  [course-id concept-id]
  [with-mui-theme "dark"
   [:div.editor-v2 {}
    [:div.page
     [ui/app-bar {:position "static"}
      [ui/toolbar
       [ui/typography {:variant "h4"} "Concept"]]]
      [ui/paper
       [edit-dataset-item-form course-id concept-id]]
     ]]])

(defn scene-view
  []
  [with-mui-theme "dark"
   [:div.editor-v2 {}
    [:div.top-side
     [data]
     [scene]]
    [diagram]
    [modal-windows]]])

(defn course-view
  []
  [with-mui-theme "dark"
   [:div.editor-v2 {}
    [:div.page
     [ui/app-bar {:position "static"}
      [ui/toolbar
       [ui/typography {:variant "h4"} "Course"]]]
    [ui/grid {:container true
              :justify   "space-between"
              :spacing 40}
     [ui/grid {:item true :xs 4}
      [concepts]]
     [ui/grid {:item true :xs 4}
      [scenes]]
     [ui/grid {:item true :xs 4}
      [lessons]]]
    ]]])