(ns webchange.demo-scenes.park.park-poem)

(def park-poem-scene
  {:assets        [{:url "/raw/img/park/sandbox/background.jpg" :size 10 :type "image"}
                   {:url "/raw/img/park/poem/i1.png" :type "image"}
                   {:url "/raw/img/park/poem/i2.png" :type "image"}
                   {:url "/raw/img/park/poem/i3.png" :type "image"}
                   {:url "/raw/img/park/poem/o1.png" :type "image"}
                   {:url "/raw/img/park/poem/o2.png" :type "image"}
                   {:url "/raw/img/park/poem/o3.png" :type "image"}
                   {:url "/raw/audio/l2/a3/poems/ardilla.m4a" :type "audio"}
                   {:url "/raw/audio/l2/a3/poems/oso.m4a" :type "audio"}
                   {:url "/raw/audio/l2/a3/poems/iman.m4a" :type "audio"}
                   {:url "/raw/audio/l2/a3/L2_A3_Mari.m4a" :size 5 :type "audio" :alias "mari voice"}]
   :audio         {:mari "/raw/audio/l2/a3/L2_A3_Mari.m4a"}
   :objects       {:background    {:type "background"
                                   :src  "/raw/img/park/sandbox/background.jpg"}
                   :image-story-1 {:type    "transparent"
                                   :src     ""
                                   :x       426
                                   :y       551
                                   :width   450
                                   :height  450
                                   :scale-y 0.25
                                   :scale-x 0.25
                                   :states  {:visible   {:type "image"}
                                             :clickable {:x       415
                                                         :y       540
                                                         :scale-y 0.3
                                                         :scale-x 0.3}}
                                   :actions {:click {:type "action" :id "image-story-1-clicked" :on "click"}}}
                   :image-story-2 {:type    "transparent"
                                   :src     ""
                                   :x       621
                                   :y       546
                                   :width   450
                                   :height  450
                                   :scale-y 0.25
                                   :scale-x 0.25
                                   :states  {:visible   {:type "image"}
                                             :clickable {:x       610
                                                         :y       535
                                                         :scale-y 0.3
                                                         :scale-x 0.3}}
                                   :actions {:click {:type "action" :id "image-story-2-clicked" :on "click"}}}
                   :image-story-3 {:type    "transparent"
                                   :src     ""
                                   :x       791
                                   :y       581
                                   :width   450
                                   :height  450
                                   :scale-y 0.25
                                   :scale-x 0.25
                                   :states  {:visible   {:type "image"}
                                             :clickable {:x       780
                                                         :y       570
                                                         :scale-y 0.3
                                                         :scale-x 0.3}}
                                   :actions {:click {:type "action" :id "image-story-3-clicked" :on "click"}}}
                   :bubble-1      {:type       "transparent"
                                   :transition "bubble-1"
                                   :src        ""
                                   :x          470
                                   :y          670
                                   :width      450
                                   :height     450
                                   :scale-y    0.6
                                   :scale-x    0.6
                                   :states     {:visible {:type "image"}
                                                :hidden  {:type "transparent"}}}
                   :bubble-2      {:type       "transparent"
                                   :transition "bubble-2"
                                   :src        ""
                                   :x          470
                                   :y          670
                                   :width      450
                                   :height     450
                                   :scale-y    0.6
                                   :scale-x    0.6
                                   :states     {:visible {:type "image"}
                                                :hidden  {:type "transparent"}}}
                   :bubble-3      {:type       "transparent"
                                   :transition "bubble-3"
                                   :src        ""
                                   :x          470
                                   :y          670
                                   :width      450
                                   :height     450
                                   :scale-y    0.6
                                   :scale-x    0.6
                                   :states     {:visible {:type "image"}
                                                :hidden  {:type "transparent"}}}
                   :mari          {:type       "animation"
                                   :name       "mari"
                                   :transition "mari"
                                   :anim       "idle"
                                   :start      true
                                   :speed      0.35
                                   :x          230
                                   :y          825
                                   :width      473
                                   :height     511
                                   :scale-y    0.5
                                   :scale-x    -0.5
                                   :states     {:listening-eva  {:scale-y 0.5
                                                                 :scale-x -0.5
                                                                 :speed   0.35}
                                                :listening-user {:scale-y 0.7
                                                                 :scale-x -0.7
                                                                 :speed   0.1}}}
                   :rock          {:type       "animation"
                                   :name       "rock"
                                   :scene-name "rock"
                                   :anim       "idle"
                                   :start      true
                                   :speed      0.35
                                   :x          1570
                                   :y          800
                                   :width      591
                                   :height     681
                                   :scale-y    0.6
                                   :scale-x    0.6}}

   :scene-objects [["background"] ["image-story-1" "image-story-2" "image-story-3"] ["bubble-1" "bubble-2" "bubble-3"] ["mari" "rock"]]
   :actions       {:clear-instruction     {:type        "remove-flows"
                                           :description "Remove flows"
                                           :flow-tag    "instruction"}
                   :start                 {:type        "sequence"
                                           :description "Initial action"
                                           :data        ["start-activity"
                                                         "clear-instruction"
                                                         "init-state"
                                                         "init-concepts"
                                                         "mari-voice-welcome"
                                                         "enable-story-1"]}

                   :start-activity        {:type "start-activity" :id "park-poem"}
                   :finish-activity       {:type "sequence-data"
                                           :data [{:type "finish-activity" :id "park-poem"}
                                                  {:type "scene" :scene-id "park"}]}

                   :init-state            {:type "sequence-data"
                                           :data [{:type "set-variable" :var-name "poem-paused" :var-value false}
                                                  {:type "set-variable" :var-name "story-1-passed" :var-value false}
                                                  {:type "set-variable" :var-name "story-2-passed" :var-value false}
                                                  {:type "set-variable" :var-name "story-3-passed" :var-value false}
                                                  {:type "set-variable" :var-name "story-1-clickable" :var-value false}
                                                  {:type "set-variable" :var-name "story-2-clickable" :var-value false}
                                                  {:type "set-variable" :var-name "story-3-clickable" :var-value false}]}

                   :enable-story-1        {:type "sequence-data"
                                           :data [{:type "state" :target "image-story-1" :id "clickable"}
                                                  {:type "set-variable" :var-name "story-1-clickable" :var-value true}]}

                   :init-concepts         {:type "sequence-data"
                                           :data [{:type        "lesson-var-provider"
                                                   :provider-id "words-set"
                                                   :variables   ["concept-1" "concept-2" "concept-3"]
                                                   :shuffled    false
                                                   :from        "concepts"}
                                                  {:type     "test-var-scalar"
                                                   :var-name "concept-1" :value nil
                                                   :success  {:type "set-variable" :var-name "story-1-passed" :var-value true}
                                                   :fail     "init-image-story-1"}
                                                  {:type     "test-var-scalar"
                                                   :var-name "concept-2" :value nil
                                                   :success  {:type "set-variable" :var-name "story-2-passed" :var-value true}
                                                   :fail     "init-image-story-2"}
                                                  {:type     "test-var-scalar"
                                                   :var-name "concept-3" :value nil
                                                   :success  {:type "set-variable" :var-name "story-3-passed" :var-value true}
                                                   :fail     "init-image-story-3"}]}

                   :none                  {:type "empty" :duration 10}

                   :init-image-story-1    {:type "sequence-data"
                                           :data [{:type "state" :target "image-story-1" :id "visible"}
                                                  {:type     "set-attribute" :target "image-story-1" :attr-name "src"
                                                   :from-var [{:var-name        "concept-1"
                                                               :var-property    "poem-image-1"
                                                               :action-property "attr-value"}]}]}

                   :init-image-story-2    {:type "sequence-data"
                                           :data [{:type "state" :target "image-story-2" :id "visible"}
                                                  {:type     "set-attribute" :target "image-story-2" :attr-name "src"
                                                   :from-var [{:var-name        "concept-2"
                                                               :var-property    "poem-image-1"
                                                               :action-property "attr-value"}]}]}

                   :init-image-story-3    {:type "sequence-data"
                                           :data [{:type "state" :target "image-story-3" :id "visible"}
                                                  {:type     "set-attribute" :target "image-story-3" :attr-name "src"
                                                   :from-var [{:var-name        "concept-3"
                                                               :var-property    "poem-image-1"
                                                               :action-property "attr-value"}]}]}

                   :image-story-1-clicked {:type    "test-var-scalar" :var-name "story-1-clickable" :value true
                                           :success {:type "sequence-data"
                                                     :data [{:type     "set-variable" :var-name "current-concept"
                                                             :from-var [{:var-name "concept-1" :action-property "var-value"}]}
                                                            {:type "set-variable" :var-name "bubble-init-position" :var-value {:x 350 :y 470}}
                                                            {:type "action" :id "run-story"}
                                                            {:type "set-variable" :var-name "story-1-passed" :var-value true}
                                                            {:type "set-variable" :var-name "story-2-clickable" :var-value true}
                                                            {:type "state" :target "image-story-2" :id "clickable"}
                                                            {:type "action" :id "test-stories-complete"}]}
                                           :fail    {:type "empty" :duration 1}}

                   :image-story-2-clicked {:type    "test-var-scalar" :var-name "story-2-clickable" :value true
                                           :success {:type "sequence-data"
                                                     :data [{:type     "set-variable" :var-name "current-concept"
                                                             :from-var [{:var-name "concept-2" :action-property "var-value"}]}
                                                            {:type "set-variable" :var-name "bubble-init-position" :var-value {:x 540 :y 465}}
                                                            {:type "action" :id "run-story"}
                                                            {:type "set-variable" :var-name "story-2-passed" :var-value true}
                                                            {:type "set-variable" :var-name "story-3-clickable" :var-value true}
                                                            {:type "state" :target "image-story-3" :id "clickable"}
                                                            {:type "action" :id "test-stories-complete"}]}
                                           :fail    {:type "empty" :duration 1}}

                   :image-story-3-clicked {:type    "test-var-scalar" :var-name "story-3-clickable" :value true
                                           :success {:type "sequence-data"
                                                     :data [{:type     "set-variable" :var-name "current-concept"
                                                             :from-var [{:var-name "concept-3" :action-property "var-value"}]}
                                                            {:type "set-variable" :var-name "bubble-init-position" :var-value {:x 540 :y 465}}
                                                            {:type "action" :id "run-story"}
                                                            {:type "set-variable" :var-name "story-3-passed" :var-value true}
                                                            {:type "action" :id "test-stories-complete"}]}
                                           :fail    {:type "empty" :duration 1}}

                   :test-stories-complete {:type      "test-var-list"
                                           :var-names ["story-1-passed" "story-2-passed" "story-3-passed"]
                                           :values    [true true true]
                                           :success   "mari-voice-finish"}

                   :run-story             {:type "sequence-data"
                                           :data [{:type "set-variable" :var-name "poem-paused" :var-value false}
                                                  {:type "action" :id "prepare-bubbles"}
                                                  {:type     "action"
                                                   :from-var [{:var-name     "current-concept"
                                                               :var-property "poem-story"}]}
                                                  {:type "action" :id "mari-voice-now-repeat"}
                                                  {:type "set-variable" :var-name "poem-paused" :var-value true}
                                                  {:type "action" :id "prepare-bubbles"}
                                                  {:type     "action"
                                                   :from-var [{:var-name     "current-concept"
                                                               :var-property "poem-story"}]}]}

                   :prepare-bubbles       {:type "sequence-data"
                                           :data [{:type "state" :target "bubble-1" :id "hidden"}
                                                  {:type     "set-attribute" :target "bubble-1" :attr-name "src"
                                                   :from-var [{:var-name "current-concept" :var-property "poem-image-1" :action-property "attr-value"}]}
                                                  {:type     "set-attribute" :target "bubble-1" :attr-name "x"
                                                   :from-var [{:var-name "bubble-init-position" :var-property "x" :action-property "attr-value"}]}
                                                  {:type     "set-attribute" :target "bubble-1" :attr-name "y"
                                                   :from-var [{:var-name "bubble-init-position" :var-property "y" :action-property "attr-value"}]}
                                                  {:type "state" :target "bubble-2" :id "hidden"}
                                                  {:type     "set-attribute" :target "bubble-2" :attr-name "src"
                                                   :from-var [{:var-name "current-concept" :var-property "poem-image-2" :action-property "attr-value"}]}
                                                  {:type     "set-attribute" :target "bubble-2" :attr-name "x"
                                                   :from-var [{:var-name "bubble-init-position" :var-property "x" :action-property "attr-value"}]}
                                                  {:type     "set-attribute" :target "bubble-2" :attr-name "y"
                                                   :from-var [{:var-name "bubble-init-position" :var-property "y" :action-property "attr-value"}]}
                                                  {:type "state" :target "bubble-3" :id "hidden"}
                                                  {:type     "set-attribute" :target "bubble-3" :attr-name "src"
                                                   :from-var [{:var-name "current-concept" :var-property "poem-image-3" :action-property "attr-value"}]}
                                                  {:type     "set-attribute" :target "bubble-3" :attr-name "x"
                                                   :from-var [{:var-name "bubble-init-position" :var-property "x" :action-property "attr-value"}]}
                                                  {:type     "set-attribute" :target "bubble-3" :attr-name "y"
                                                   :from-var [{:var-name "bubble-init-position" :var-property "y" :action-property "attr-value"}]}
                                                  {:type "empty" :duration 300}]}

                   :run-bubble-1          {:type "sequence-data"
                                           :data [{:type "state" :target "bubble-1" :id "visible"}
                                                  {:type "empty" :duration 100}
                                                  {:type "transition" :transition-id "bubble-1"
                                                   :to   {:bezier   [{:x 335 :y 390} {:x 350 :y 230} {:x 175 :y 100}]
                                                          :duration 2.0}}]}

                   :run-bubble-2          {:type "sequence-data"
                                           :data [{:type "state" :target "bubble-2" :id "visible"}
                                                  {:type "empty" :duration 100}
                                                  {:type "transition" :transition-id "bubble-2"
                                                   :to   {:bezier   [{:x 440 :y 215} {:x 735 :y 60}]
                                                          :duration 2.0}}]}

                   :run-bubble-3          {:type "sequence-data"
                                           :data [{:type "state" :target "bubble-3" :id "visible"}
                                                  {:type "empty" :duration 100}
                                                  {:type "transition" :transition-id "bubble-3"
                                                   :to   {:bezier   [{:x 740 :y 450} {:x 950 :y 160} {:x 1315 :y 125}]
                                                          :duration 2.0}}]}

                   :mari-listening-eva    {:type "state" :target "mari" :id "listening-eva"}

                   :mari-listening-user   {:type "state" :target "mari" :id "listening-user"}

                   :mari-voice-welcome    {:type        "parallel"
                                           :description "Bienvendio al parque pequeno genio! Te gustaria escuchar una corta historia?"
                                           :data        [{:type "audio" :id "mari" :start 0.584 :duration 6.661}
                                                         {:type "animation-sequence" :target "mari" :track 1 :offset 0.584
                                                          :data [{:start 0.757 :end 3.406 :anim "talk"}
                                                                 {:start 3.925 :end 7.083 :anim "talk"}]}]}

                   :mari-voice-now-repeat {:type        "parallel"
                                           :description "Te gusto eso? Espero que si. Vamos a escuchar la historia de nuevo,
                                                          pero esta vez, quiero que TU cuentes la historia conmigo.
                                                          Repite cada frase fuerte y en voz alta."
                                           :data        [{:type "audio" :id "mari" :start 12.490 :duration 15.950}
                                                         {:type "animation-sequence" :target "mari" :track 1 :offset 12.490
                                                          :data [{:start 12.598 :end 13.917 :anim "talk"}
                                                                 {:start 14.544 :end 15.799 :anim "talk"}
                                                                 {:start 16.469 :end 19.021 :anim "talk"}
                                                                 {:start 19.411 :end 21.844 :anim "talk"}
                                                                 {:start 22.244 :end 24.212 :anim "talk"}
                                                                 {:start 24.666 :end 28.299 :anim "talk"}]}]}

                   :mari-voice-finish     {:type        "parallel"
                                           :description "Bravo! Te gustaria escuchar la historia de nuevo?
                                                      Toca la foto para escuchar de nuevo, o toca la flecha para seguir a tu proxima actividad!"
                                           :data        [{:type "audio" :id "mari" :start 30.397 :duration 12.706}
                                                         {:type "animation-sequence" :target "mari" :track 1 :offset 30.397
                                                          :data [{:start 30.559 :end 31.446 :anim "talk"}
                                                                 {:start 31.792 :end 34.928 :anim "talk"}
                                                                 {:start 35.988 :end 38.572 :anim "talk"}
                                                                 {:start 39.016 :end 42.930 :anim "talk"}]}]}}
   :triggers      {:music {:on "start" :action "start"}}
   :metadata      {:autostart true
                   :prev      "map"}})