(ns webchange.editor-v2.creation-progress.views-short-info
  (:require
    [cljs-react-material-ui.reagent :as ui]
    [re-frame.core :as re-frame]
    [reagent.core :as r]
    [webchange.ui.theme :refer [get-in-theme]]
    [webchange.editor-v2.creation-progress.state :as state]
    [webchange.editor-v2.creation-progress.warning-icon :refer [warning-icon]]))

(defn- bar-content
  []
  (let [progress-data @(re-frame/subscribe [::state/translation-progress])
        progress-value (-> (:progress progress-data) (* 100) (Math/round))]
    [:div {:style {:width       "250px"
                   :height      "30px"
                   :display     "flex"
                   :align-items "center"}}
     (when-not (= progress-value 100)
       [warning-icon {:styles {:main {:margin-right "10px"}}}])
     [:div {:style {:flex-grow 1}}
      [ui/typography "Activity completion: " progress-value "%"]
      [ui/linear-progress {:variant "determinate"
                           :value   progress-value
                           :style   {:margin-top "4px"}}]]]))

(defn short-info
  []
  (let [{:keys [mode show?]} @(re-frame/subscribe [::state/window-state])
        handle-click (fn [] (re-frame/dispatch [::state/show-translation-full-progress]))]
    [ui/snackbar {:open          (and show? (= mode :short-info))
                  :anchor-origin {:vertical   "bottom"
                                  :horizontal "right"}
                  :on-click      handle-click}
     [ui/snackbar-content {:style   {:background-color (get-in-theme [:palette :background :paper])
                                     :cursor           "pointer"}
                           :message (r/as-element [bar-content])}]]))
