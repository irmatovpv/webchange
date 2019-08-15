(ns webchange.demo-scenes.home.home)

(def home-scene
  {:assets
                  [{:url "/raw/audio/ferris-wheel/fw-try-again.mp3", :size 2, :type "audio"}

                   {:url "/raw/img/casa/background.jpg", :size 10 :type "image"}
                   {:url "/raw/img/casa_door.png", :size 1, :type "image"}

                   {:url "/raw/audio/l1/a1/L1_A1_Vaca_Ardilla.m4a", :size 2, :type "audio" :alias "vaca voice 1"}
                   {:url "/raw/audio/l1/a1/L1_A1_Vaca_Oso.m4a", :size 2, :type "audio" :alias "vaca voice 2"}
                   {:url "/raw/audio/l1/a1/L1_A1_Vaca_Iman.m4a", :size 2, :type "audio" :alias "vaca voice 3"}
                   {:url "/raw/audio/l1/a1/L1_A1_Vaca_Diamente.m4a", :size 2, :type "audio" :alias "vaca voice diamante"}
                   {:url "/raw/audio/l1/a1/L1_A1_Vaca_Object_1_insertions.m4a", :size 2, :type "audio" :alias "vaca insertions 1"}
                   {:url "/raw/audio/l1/a1/L1_A1_Vaca_Object_2_insertions.m4a", :size 2, :type "audio" :alias "vaca insertions 2"}
                   {:url "/raw/audio/l1/a1/L1_A1_Vaca_Object_3_insertions.m4a", :size 2, :type "audio" :alias "vaca insertions 3"}
                   {:url "/raw/audio/l1/a1/L1_A1_Vera_Ardilla.m4a", :size 2, :type "audio" :alias "vera voice 1"}
                   {:url "/raw/audio/l1/a1/L1_A1_Vera_Oso.m4a", :size 2, :type "audio" :alias "vera voice 2"}
                   {:url "/raw/audio/l1/a1/L1_A1_Vera_Iman.m4a", :size 2, :type "audio" :alias "vera voice 3"}
                   {:url "/raw/audio/l1/a1/L1_A1_Vera_Diamante.m4a", :size 2, :type "audio" :alias "vera voice diamante"}
                   {:url "/raw/audio/l1/a1/L1_A1_Vera_Object_1_insertions.m4a", :size 2, :type "audio" :alias "vera insertions 1"}
                   {:url "/raw/audio/l1/a1/L1_A1_Vera_Object_2_insertions.m4a", :size 2, :type "audio" :alias "vera insertions 2"}
                   {:url "/raw/audio/l1/a1/L1_A1_Vera_Object_3_insertions.m4a", :size 2, :type "audio" :alias "vera insertions 3"}
                   ],
   :objects
                  {:background {:type "background", :src "/raw/img/casa/background.jpg"},
                   :vera       {:type "animation" :x 1128 :y 960 :name "vera" :anim "idle" :speed 0.3
                                :width 1800 :height 2558 :scale {:x 0.2 :y 0.2} :start true}
                   :senora-vaca {:type "animation" :x 655 :y 960 :name "senoravaca" :anim "idle" :speed 0.3
                                 :width 351 :height 717 :scale {:x 1 :y 1} :start true
                                 :actions {:click {:type "action" :id "intro" :on "click" :options {:unique-tag "intro"}}}}

                   :door-trigger {:type "transparent" :x 1146 :y 42 :width 732 :height 810
                                  :actions {:click {:type "scene", :scene-id "map", :on "click"}}}

                   :box1 {:type "transparent" :x 400 :y 300 :width 206 :height 210 :origin {:type "center-center"}
                          :scene-name "box1"
                          :states {:default {:type "transparent"}
                                   :visible {:type "animation" :name "boxes" :anim "come" :skin "qwestion"
                                             :scale {:x 0.25 :y 0.25} :speed 0.3 :loop false :start true}}
                          :actions {:click {:type "action" :id "click-on-box1" :on "click"}}}

                   :box2 {:type "transparent" :x 850 :y 300 :width 206 :height 210 :origin {:type "center-center"}
                          :scene-name "box2"
                          :states {:default {:type "transparent"}
                                   :visible {:type "animation" :name "boxes" :anim "come" :skin "qwestion"
                                             :scale {:x 0.25 :y 0.25} :speed 0.3 :loop false :start true}}
                          :actions {:click {:type "action" :id "click-on-box2" :on "click"}}}

                   :box3 {:type "transparent" :x 1300 :y 300 :width 206 :height 210 :origin {:type "center-center"}
                          :scene-name "box3"
                          :states {:default {:type "transparent"}
                                   :visible {:type "animation" :name "boxes" :anim "come" :skin "qwestion"
                                             :scale {:x 0.25 :y 0.25} :speed 0.3 :loop false :start true}}
                          :actions {:click {:type "action" :id "click-on-box3" :on "click"}}}

                   },
   :scene-objects [["background"] ["vera" "senora-vaca"] ["door-trigger"] ["box1" "box2" "box3"]],
   :actions
                  {:senora-vaca-audio-1
                   {:type "parallel"
                    :data [{:type "audio", :id "vaca-1", :start 1.089, :duration 2.749}
                           {:type "animation-sequence" :target "senoravaca" :track 1 :offset 1.089
                            :data [{:start 1.089 :end 3.596 :anim "talk"}]}]}

                   :senora-vaca-audio-2
                   {:type "parallel"
                    :data [{:type "audio", :id "vaca-1", :start 4.395, :duration 10.042}
                           {:type "animation-sequence" :target "senoravaca" :track 1 :offset 4.395
                            :data [{:start 4.395 :end 5.484 :anim "talk"}
                                   {:start 6.423 :end 8.745 :anim "talk"}
                                   {:start 9.607 :end 10.342 :anim "talk"}
                                   {:start 11.226 :end 14.302 :anim "talk"}]}]}

                   :senora-vaca-audio-touch-second-box
                   {:type "parallel"
                    :data [{:type "audio", :id "vaca-2", :start 0.587, :duration 8.772}
                           {:type "animation-sequence" :target "senoravaca" :track 1 :offset 0.587
                            :data [{:start 0.873 :end 2.053 :anim "talk"}
                                   {:start 2.794 :end 4.952 :anim "talk"}
                                   {:start 5.336 :end 6.67 :anim "talk"}
                                   {:start 7.697 :end 9.136 :anim "talk"}]}]}

                   :senora-vaca-audio-touch-third-box
                   {:type "parallel"
                    :data [{:type "audio", :id "vaca-3", :start 0.76, :duration 4.986}
                           {:type "animation-sequence" :target "senoravaca" :track 1 :offset 0.76
                            :data [{:start 0.844 :end 1.844 :anim "talk"}
                                   {:start 2.214 :end 2.733 :anim "talk"}
                                   {:start 2.928 :end 5.674 :anim "talk"}]}]}

                   :show-boxes {:type "parallel"
                                :data [{:type "state" :target "box1" :id "visible"}
                                       {:type "state" :target "box2" :id "visible"}
                                       {:type "state" :target "box3" :id "visible"}]}

                   :switch-box-animations-idle {:type "parallel"
                                                :data [{:type "add-animation" :target "box1" :id "idle_fly1" :loop true}
                                                       {:type "add-animation" :target "box2" :id "idle_fly2" :loop true}
                                                       {:type "add-animation" :target "box3" :id "idle_fly3" :loop true}]}

                   :wait-for-box-animations {:type "empty" :duration 500}

                   :intro {:type "sequence",
                               :data ["start-activity"
                                      "clear-instruction"
                                      "renew-words"
                                      "senora-vaca-audio-1"
                                      "set-current-box1"
                                      "show-boxes"
                                      "wait-for-box-animations"
                                      "switch-box-animations-idle"
                                      "senora-vaca-audio-2"
                                      ]},

                   :set-current-box1 {:type "set-variable" :var-name "current-box" :var-value "box1"}
                   :set-current-box2 {:type "set-variable" :var-name "current-box" :var-value "box2"}
                   :set-current-box3 {:type "set-variable" :var-name "current-box" :var-value "box3"}

                   :click-on-box1 {:type "test-var-scalar"
                                   :var-name "current-box"
                                   :value "box1"
                                   :success "first-word"
                                   :fail "pick-wrong"}

                   :click-on-box2 {:type "test-var-scalar"
                                   :var-name "current-box"
                                   :value "box2"
                                   :success "second-word"
                                   :fail "pick-wrong"}

                   :click-on-box3 {:type "test-var-scalar"
                                   :var-name "current-box"
                                   :value "box3"
                                   :success "third-word"
                                   :fail "pick-wrong"}

                   :first-word {:type "sequence"
                                :data ["show-first-box-word"
                                       "introduce-word"
                                       "set-current-box2"
                                       "senora-vaca-audio-touch-second-box"]}

                   :second-word {:type "sequence"
                                 :data ["show-second-box-word"
                                        "introduce-word"
                                        "set-current-box3"
                                        "senora-vaca-audio-touch-third-box"]}

                   :third-word {:type "sequence"
                                :data ["show-third-box-word"
                                       "introduce-word"
                                       "finish-activity"
                                       "mari-finish"]}

                   :show-first-box-word {:type "parallel"
                                         :data [{:type "animation" :target "box1" :id "wood" :loop false}
                                                {:type "set-skin" :target "box1"
                                                 :from-var [{:var-name "item-1" :action-property "skin" :var-property "skin"}]}
                                                {:type "copy-variable" :var-name "current-word" :from "item-1"}
                                                {:type "add-animation" :target "box1" :id "idle_fly1" :loop true}]}

                   :show-second-box-word {:type "parallel"
                                         :data [{:type "animation" :target "box2" :id "wood" :loop false}
                                                {:type "set-skin" :target "box2"
                                                 :from-var [{:var-name "item-2" :action-property "skin" :var-property "skin"}]}
                                                {:type "copy-variable" :var-name "current-word" :from "item-2"}
                                                {:type "add-animation" :target "box2" :id "idle_fly2" :loop true}]}

                   :show-third-box-word {:type "parallel"
                                         :data [{:type "animation" :target "box3" :id "wood" :loop false}
                                                {:type "set-skin" :target "box3"
                                                 :from-var [{:var-name "item-3" :action-property "skin" :var-property "skin"}]}
                                                {:type "copy-variable" :var-name "current-word" :from "item-3"}
                                                {:type "add-animation" :target "box3" :id "idle_fly3" :loop true}]}

                   :vaca-this-is-var {:type "action" :from-var [{:var-name "current-word" :var-property "home-vaca-this-is-action"}]}

                   :vaca-can-you-say {:type "parallel"
                                      :data [{:type "audio", :id "vaca-3", :start 11.75, :duration 0.935}
                                             {:type "animation-sequence" :target "senoravaca" :track 1 :offset 11.75
                                              :data [{:start 11.75 :end 12.62 :anim "talk"}]}]}

                   :vaca-question-var {:type "action" :from-var [{:var-name "current-word" :var-property "home-vaca-question-action"}]}

                   :vaca-word-var {:type "action" :from-var [{:var-name "current-word" :var-property "home-vaca-word-action"}]}

                   :group-word-var {:type "action" :from-var [{:var-name "current-word" :var-property "home-group-word-action"}]}

                   :vaca-say-3-times {:type "parallel"
                                      :data [{:type "audio", :id "vaca-1", :start 25.079, :duration 2.381}
                                             {:type "animation-sequence" :target "senoravaca" :track 1 :offset 25.079
                                              :data [{:start 25.152 :end 25.513 :anim "talk"}
                                                     {:start 25.853 :end 27.2 :anim "talk"}]}]}

                   :vaca-3-times-var {:type "action" :from-var [{:var-name "current-word" :var-property "home-vaca-3-times-action"}]}

                   :group-3-times-var {:type "action" :from-var [{:var-name "current-word" :var-property "home-group-3-times-action"}]}

                   :vaca-once-more {:type "parallel"
                                      :data [{:type "audio", :id "vaca-1", :start 37.751, :duration 1.187}
                                             {:type "animation-sequence" :target "senoravaca" :track 1 :offset 37.751
                                              :data [{:start 37.751 :end 38.792 :anim "talk"}]}]}

                   :vaca-goodbye-var {:type "action" :from-var [{:var-name "current-word" :var-property "home-vaca-goodbye-action"}]}

                   :introduce-word {:type "sequence"
                                    :data ["empty-big"
                                           "vaca-this-is-var"
                                           "empty-small"
                                           "vaca-can-you-say"
                                           "vaca-question-var"
                                           "empty-small"
                                           "vaca-word-var"
                                           "empty-big"
                                           "group-word-var"
                                           "empty-small"
                                           "vaca-say-3-times"
                                           "vaca-3-times-var"
                                           "empty-big"
                                           "group-3-times-var"
                                           "empty-small"
                                           "vaca-once-more"
                                           "empty-small"
                                           "group-3-times-var"
                                           "empty-small"
                                           "vaca-goodbye-var"
                                           "empty-big"]}

                   :senora-vaca-anim-idle {:type "animation" :target "senoravaca" :id "idle"}
                   :senora-vaca-anim-clapping-start {:type "animation" :target "senoravaca" :id "clapping_start" :loop false}
                   :senora-vaca-anim-clapping-finish {:type "animation" :target "senoravaca" :id "clapping_finish" :loop false}
                   :vera-anim-idle {:type "animation" :target "vera" :id "idle"}
                   :vera-anim-clapping-start {:type "animation" :target "vera" :id "clapping_start" :loop false}
                   :vera-anim-clapping-finish {:type "animation" :target "vera" :id "clapping_finish" :loop false}


                   :pick-wrong {:type "sequence"
                                :data ["audio-wrong"]}

                   :audio-wrong {:type "audio" :id "fw-try-again" :start 0.892 :duration 1.869 :offset 0.2}

                   :renew-words  {:type "lesson-var-provider"
                                  :provider-id "words-set"
                                  :variables ["item-1" "item-2" "item-3"]
                                  :from      "concepts"}

                   :empty-small {:type "empty" :duration 500}
                   :empty-big {:type "empty" :duration 1000}
                   :clear-instruction {:type "remove-flows" :flow-tag "instruction"}
                   :start-background-music {:type "audio" :id "background" :loop true}
                   :start-activity {:type "start-activity" :id "home"}
                   :finish-activity {:type "finish-activity" :id "home"}
                   :stop-activity {:type "stop-activity" :id "home"}}
   :audio
                  {:casa-welcome "/raw/audio/scripts/intro/intro-welcome.mp3"
                   :casa-finish "/raw/audio/scripts/intro/intro-finish.mp3"
                   :background "/raw/audio/background/POL-daily-special-short.mp3"
                   :fw-try-again "/raw/audio/ferris-wheel/fw-try-again.mp3"
                   :vaca-1 "/raw/audio/l1/a1/L1_A1_Vaca_Ardilla.m4a"
                   :vaca-2 "/raw/audio/l1/a1/L1_A1_Vaca_Oso.m4a"
                   :vaca-3 "/raw/audio/l1/a1/L1_A1_Vaca_Iman.m4a"
                   :vera-1 "/raw/audio/l1/a1/L1_A1_Vera_Ardilla.m4a"
                   :vera-2 "/raw/audio/l1/a1/L1_A1_Vera_Oso.m4a"
                   :vera-3 "/raw/audio/l1/a1/L1_A1_Vera_Iman.m4a"},
   :triggers      {:music {:on "start" :action "start-background-music"}
                   :back {:on "back" :action "stop-activity"}}
   :metadata      {:autostart true
                   :prev "map"}})