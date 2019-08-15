(ns webchange.demo-scenes.cinema.cinema_video)

(def cinema-video-scene {:assets        [{:url "/raw/img/cinema/background.jpg", :size 10, :type "image"}
                                         {:url "/raw/img/cinema/screen-off.png", :size 10, :type "image"}
                                         {:url "/raw/img/ui/play_button_01.png", :size 10, :type "image"}
                                         {:url "/raw/img/ui/next_button_01.png", :size 10, :type "image"}
                                         {:url "/raw/audio/l2/a1/L2_A1_Mari.m4a", :size 5, :type "audio" :alias "vaca voice 1"}
                                         {:url "/raw/audio/l2/a1/L2_A1_Vaca_7.m4a", :size 5, :type "audio" :alias "vaca voice 7"}]
                         :audio         {:mari   "/raw/audio/l2/a1/L2_A1_Mari.m4a"
                                         :vaca-7 "/raw/audio/l2/a1/L2_A1_Vaca_7.m4a"}
                         :objects       {:background     {:type "background"
                                                          :src  "/raw/img/cinema/background.jpg"}
                                         :screen-overlay {:type   "image"
                                                          :src    "/raw/img/cinema/screen-off.png"
                                                          :width  1238
                                                          :height 678
                                                          :x      342
                                                          :y      109
                                                          :states {:hidden  {:type "transparent"}
                                                                   :visible {:type "image"}}}
                                         :mari           {:type       "animation"
                                                          :name       "mari"
                                                          :transition "mari"
                                                          :anim       "idle"
                                                          :start      true
                                                          :speed      0.35
                                                          :x          1613
                                                          :y          785
                                                          :width      473
                                                          :height     511
                                                          :scale-y    0.3
                                                          :scale-x    0.3}
                                         :video-controls {:type     "transparent"
                                                          :x        616
                                                          :y        400
                                                          :width    730
                                                          :height   100
                                                          :children ["play-button" "next-button"]
                                                          :states   {:hidden  {:type "transparent"}
                                                                     :visible {:type "group"}}}
                                         :play-button    {:type    "image"
                                                          :src     "/raw/img/ui/play_button_01.png"
                                                          :width   331
                                                          :height  99
                                                          :x       0
                                                          :y       0
                                                          :states  {:left   {:x 0}
                                                                    :center {:x 200}}
                                                          :actions {:click {:type "action"
                                                                            :id   "play-video"
                                                                            :on   "click"}}}
                                         :next-button    {:type    "transparent"
                                                          :src     "/raw/img/ui/next_button_01.png"
                                                          :width   331
                                                          :height  98
                                                          :x       400
                                                          :y       0
                                                          :states  {:hidden  {:type "transparent" :y 1000}
                                                                    :visible {:type "image" :y 0}}
                                                          :actions {:click {:type "action"
                                                                            :id   "finish-activity"
                                                                            :on   "click"}}}
                                         :senora-vaca    {:type    "animation"
                                                          :name    "senoravaca"
                                                          :anim    "idle"
                                                          :start   true
                                                          :speed   0.3
                                                          :x       263
                                                          :y       915
                                                          :width   351
                                                          :height  717
                                                          :scale-y 0.5
                                                          :scale-x 0.5}
                                         :letter-video   {:type   "transparent"
                                                          :width  1236
                                                          :height 674
                                                          :x      342
                                                          :y      111
                                                          :states {:hidden  {:type "transparent"}
                                                                   :visible {:type "video"}}}}
                         :scene-objects [["background"]
                                         ["letter-video" "screen-overlay"]
                                         ["video-controls"]
                                         ["senora-vaca" "mari"]]
                         :actions       {:clear-instruction        {:type        "remove-flows"
                                                                    :description "Remove flows"
                                                                    :flow-tag    "instruction"}

                                         :start                    {:type        "sequence"
                                                                    :description "Initial action"
                                                                    :data        ["start-activity"
                                                                                  "clear-instruction"
                                                                                  "renew-concept"
                                                                                  "vaca-voice-wonderful"
                                                                                  "vaca-voice-lets-watch"
                                                                                  "show-play-form"]}

                                         :renew-concept            {:type        "lesson-var-provider"
                                                                    :from        "concepts"
                                                                    :provider-id "concepts"
                                                                    :variables   ["current-concept"]}

                                         :play-video               {:type "sequence-data"
                                                                    :data [{:type "action" :id "hide-play-form"}
                                                                           {:type "state" :target "screen-overlay" :id "hidden"}
                                                                           {:type "state" :target "letter-video" :id "visible"}
                                                                           {:type "play-video" :target "letter-video"
                                                                            :from-var [{:var-name        "current-concept"
                                                                                        :var-property    "chanting-video-src"
                                                                                        :action-property "src"}]}
                                                                           {:type "action" :id "play-video-finish"}]}

                                         :play-video-finish        {:type "sequence-data"
                                                                    :data [{:type "state" :target "letter-video" :id "hidden"}
                                                                           {:type "state" :target "screen-overlay" :id "visible"}
                                                                           {:type "action" :id "vaca-clapping"}
                                                                           {:type "action" :id "vaca-voice-very-good"}
                                                                           {:type "action" :id "show-play-again-form"}]}

                                         :show-play-form           {:type "sequence-data"
                                                                    :data [{:type "parallel"
                                                                            :data [{:type "state" :target "next-button" :id "hidden"}
                                                                                   {:type "state" :target "play-button" :id "center"}
                                                                                   {:type "state" :target "video-controls" :id "visible"}]}
                                                                           {:type "transition" :transition-id "mari" :to {:x 1223 :y 546 :duration 1.5 :loop false}}
                                                                           {:type "action" :id "mari-voice-touch"}]}

                                         :show-play-again-form     {:type "sequence-data"
                                                                    :data [{:type "parallel"
                                                                            :data [{:type "state" :target "next-button" :id "visible"}
                                                                                   {:type "state" :target "play-button" :id "left"}
                                                                                   {:type "state" :target "video-controls" :id "visible"}]}
                                                                           {:type "transition" :transition-id "mari" :to {:x 990 :y 540 :duration 1.5 :loop false}}
                                                                           {:type "action" :id "mari-voice-touch-again-1"}
                                                                           {:type "transition" :transition-id "mari" :to {:x 1400 :y 540 :duration 1.5 :loop false}}
                                                                           {:type "action" :id "mari-voice-touch-again-2"}]}

                                         :hide-play-form           {:type "parallel"
                                                                    :data [{:type "state" :target "video-controls" :id "hidden"}
                                                                           {:type "transition" :transition-id "mari" :to {:x 1613 :y 785 :duration 1.5 :loop false}}]}

                                         :start-activity           {:type "start-activity" :id "cinema-video"}
                                         :finish-activity          {:type "sequence-data"
                                                                    :data [{:type "finish-activity" :id "cinema-video"}
                                                                           {:type "scene" :scene-id "map"}]}

                                         :vaca-clapping            {:type "sequence-data"
                                                                    :data [{:type "animation" :target "senoravaca" :id "clapping_start" :loop false}
                                                                           {:type "animation-sequence" :target "senoravaca" :track 1 :offset 0
                                                                            :data [{:start 0 :end 3 :anim "clapping_1clap"}]}
                                                                           {:type "animation" :target "senoravaca" :id "clapping_finish" :loop false}]}

                                         :vaca-voice-wonderful     {:type        "parallel"
                                                                    :description "Maravilloso! Todos cantaron muy bien!  Amigas, estan pasando un buen rato?"
                                                                    :data        [{:type "audio" :id "vaca-7" :start 9.716 :duration 10.613}
                                                                                  {:type "animation-sequence" :target "senoravaca" :track 1 :offset 9.716
                                                                                   :data [{:start 10.040 :end 11.858 :anim "talk"}
                                                                                          {:start 12.431 :end 14.723 :anim "talk"}
                                                                                          {:start 15.695 :end 16.691 :anim "talk"}
                                                                                          {:start 17.115 :end 19.979 :anim "talk"}]}]}

                                         :vaca-voice-lets-watch    {:type        "parallel"
                                                                    :description "Excellent! Now, let’s watch a video about the letter ‘a’"
                                                                    :data        [{:type "audio" :id "vaca-7" :start 21.150 :duration 5.356}
                                                                                  {:type "animation-sequence" :target "senoravaca" :track 1 :offset 21.150
                                                                                   :data [{:start 21.300 :end 22.072 :anim "talk"}
                                                                                          {:start 22.371 :end 24.065 :anim "talk"}
                                                                                          {:start 24.464 :end 25.610 :anim "talk"}
                                                                                          {:start 25.859 :end 26.382 :anim "talk"}]}]}

                                         :vaca-voice-very-good     {:type        "parallel"
                                                                    :description "Very good!"
                                                                    :data        [{:type "audio" :id "vaca-7" :start 27.148 :duration 1.532}
                                                                                  {:type "animation-sequence" :target "senoravaca" :track 1 :offset 27.148
                                                                                   :data [{:start 27.297 :end 28.618 :anim "talk"}]}]}

                                         :mari-voice-touch         {:type        "parallel"
                                                                    :description "Toca aqui para ver el video"
                                                                    :data        [{:type "audio" :id "mari" :start 12.841 :duration 2.479}
                                                                                  {:type "animation-sequence" :target "mari" :track 1 :offset 12.841
                                                                                   :data [{:start 12.994 :end 15.205 :anim "talk"}]}]}

                                         :mari-voice-touch-again-1 {:type        "parallel"
                                                                    :description "Toca aqui para ver el video de nuevo..."
                                                                    :data        [{:type "audio" :id "mari" :start 18.667 :duration 3.271}
                                                                                  {:type "animation-sequence" :target "mari" :track 1 :offset 18.667
                                                                                   :data [{:start 18.820 :end 21.861 :anim "talk"}]}]}

                                         :mari-voice-touch-again-2 {:type        "parallel"
                                                                    :description "..., o toca aqui para ir a tu proxima actividad."
                                                                    :data        [{:type "audio" :id "mari" :start 22.360 :duration 4.025}
                                                                                  {:type "animation-sequence" :target "mari" :track 1 :offset 22.360
                                                                                   :data [{:start 22.475 :end 26.257 :anim "talk"}]}]}}
                         :triggers      {:start {:on "start" :action "start"}}
                         :metadata      {:autostart true
                                         :prev      "park"}})
