(ns webchange.dashboard.common.views-content-wrappers
  (:require
    [cljs-react-material-ui.reagent :as ui]))

(def padding 20)

(defn content-page
  [{:keys [title current-title actions]} & children]
  [ui/grid
   {:container true
    :spacing   24
    :style     {:padding padding
                :margin  0
                :width   "100%"}}
   [ui/grid
    {:item true
     :xs   6}
    [ui/typography
     {:variant "h4"}
     (when current-title
       (str "\"" current-title "\" "))
     title]]
   (when actions
     [ui/grid
      {:item true
       :xs   6
       :style {:text-align "right"}}
      actions])
   (for [child children]
     ^{:key child}
     [ui/grid
      {:item true
       :xs   12}
      [ui/paper
       {:style {:padding padding}}
       child]])])

(defn content-page-section
  [{:keys [title]} & children]
  [ui/grid
   {:container true
    :spacing   16}
   (when title
     [ui/grid
      {:item true
       :xs   12}
      [ui/typography
       {:variant "h6"}
       title]])
   (for [child children]
     ^{:key child}
     [ui/grid
      {:item true
       :xs   12}
      child])])
