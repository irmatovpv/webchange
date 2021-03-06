(ns webchange.editor-v2.graph-builder.graph.data.pinata.source)

(def data {:assets
                     [{:url "/raw/img/park/pinata/background.jpg", :type "image"}
                      {:url "/raw/audio/l2/a11/L2_A11_Mari.m4a", :type "audio"}
                      {:url "/raw/audio/l2/mari-chants.m4a", :size 5, :type "audio", :alias "mari chants"}],
           :objects
                     {:background {:type "background", :src "/raw/img/park/pinata/background.jpg"},
                      :box1
                                  {:type       "transparent",
                                   :x          205,
                                   :y          930,
                                   :width      671,
                                   :height     633,
                                   :scene-name "box1",
                                   :transition "box1",
                                   :actions    {:drag-end {:id "check-box-drop", :on "drag-end", :type "action", :params {:target "box1"}}},
                                   :anim       "idle2",
                                   :draggable  {:var-name "drag-box-1"},
                                   :loop       true,
                                   :name       "boxes",
                                   :scale-x    0.25,
                                   :scale-y    0.25,
                                   :skin       "qwestion",
                                   :speed      0.3,
                                   :start      true},
                      :box1-ph
                                  {:type       "transparent",
                                   :x          880,
                                   :y          930,
                                   :width      40,
                                   :height     40,
                                   :scene-name "box1-ph",
                                   :transition "box1-ph",
                                   :scale-x    1,
                                   :scale-y    1},
                      :box2
                                  {:type       "transparent",
                                   :x          410,
                                   :y          985,
                                   :width      671,
                                   :height     633,
                                   :scene-name "box2",
                                   :transition "box2",
                                   :actions    {:drag-end {:id "check-box-drop", :on "drag-end", :type "action", :params {:target "box2"}}},
                                   :anim       "idle2",
                                   :draggable  {:var-name "drag-box-2"},
                                   :loop       true,
                                   :name       "boxes",
                                   :scale-x    0.25,
                                   :scale-y    0.25,
                                   :skin       "qwestion",
                                   :speed      0.3,
                                   :start      true},
                      :box2-ph
                                  {:type       "transparent",
                                   :x          1110,
                                   :y          930,
                                   :width      40,
                                   :height     40,
                                   :scene-name "box2-ph",
                                   :transition "box2-ph",
                                   :scale-x    1,
                                   :scale-y    1},
                      :box3
                                  {:type       "transparent",
                                   :x          610,
                                   :y          955,
                                   :width      671,
                                   :height     633,
                                   :scene-name "box3",
                                   :transition "box3",
                                   :actions    {:drag-end {:id "check-box-drop", :on "drag-end", :type "action", :params {:target "box3"}}},
                                   :anim       "idle2",
                                   :draggable  {:var-name "drag-box-3"},
                                   :loop       true,
                                   :name       "boxes",
                                   :scale-x    0.25,
                                   :scale-y    0.25,
                                   :skin       "qwestion",
                                   :speed      0.3,
                                   :start      true},
                      :box3-ph
                                  {:type       "transparent",
                                   :x          1340,
                                   :y          930,
                                   :width      40,
                                   :height     40,
                                   :scene-name "box3-ph",
                                   :transition "box3-ph",
                                   :scale-x    1,
                                   :scale-y    1},
                      :letter1
                                  {:type           "text",
                                   :x              850,
                                   :y              760,
                                   :width          150,
                                   :height         150,
                                   :align          "center",
                                   :fill           "white",
                                   :font-family    "Lexend Deca",
                                   :font-size      140,
                                   :scale-x        1,
                                   :scale-y        1,
                                   :text           "",
                                   :vertical-align "bottom"},
                      :letter2
                                  {:type           "text",
                                   :x              1050,
                                   :y              760,
                                   :width          150,
                                   :height         150,
                                   :align          "center",
                                   :fill           "white",
                                   :font-family    "Lexend Deca",
                                   :font-size      140,
                                   :scale-x        1,
                                   :scale-y        1,
                                   :text           "",
                                   :vertical-align "bottom"},
                      :letter3
                                  {:type           "text",
                                   :x              1250,
                                   :y              760,
                                   :width          150,
                                   :height         150,
                                   :align          "center",
                                   :fill           "white",
                                   :font-family    "Lexend Deca",
                                   :font-size      140,
                                   :scale-x        1,
                                   :scale-y        1,
                                   :text           "",
                                   :vertical-align "bottom"},
                      :mari
                                  {:type       "animation",
                                   :x          1100,
                                   :y          420,
                                   :width      473,
                                   :height     511,
                                   :scene-name "mari",
                                   :transition "mari",
                                   :anim       "idle",
                                   :loop       true,
                                   :name       "mari",
                                   :scale-x    0.5,
                                   :scale-y    0.5,
                                   :speed      0.35,
                                   :start      true},
                      :pinata
                                  {:type       "animation",
                                   :x          925,
                                   :y          555,
                                   :width      678,
                                   :height     899,
                                   :scene-name "pinata",
                                   :transition "pinata",
                                   :anim       "idle",
                                   :loop       true,
                                   :name       "pinata",
                                   :scale-x    1,
                                   :scale-y    1,
                                   :speed      0.35,
                                   :start      true}},
           :scene-objects
                     [["background"]
                      ["pinata" "mari"]
                      ["letter1" "letter2" "letter3"]
                      ["box1-ph" "box2-ph" "box3-ph"]
                      ["box1" "box2" "box3"]],
           :actions
                     {:boxes-disappear
                                              {:type "parallel",
                                               :data
                                                     [{:skin "qwestion", :type "set-skin", :target "box1"}
                                                      {:skin "qwestion", :type "set-skin", :target "box2"}
                                                      {:skin "qwestion", :type "set-skin", :target "box3"}
                                                      {:type "set-attribute", :target "box1", :attr-name "type", :attr-value "transparent"}
                                                      {:type "set-attribute", :target "box2", :attr-name "type", :attr-value "transparent"}
                                                      {:type "set-attribute", :target "box3", :attr-name "type", :attr-value "transparent"}]},
                      :boxes-jump-out
                                              {:type "sequence-data",
                                               :data
                                                     [{:id "boxes-reset-position", :type "action"}
                                                      {:id "boxes-show-up", :type "action"}
                                                      {:id "boxes-move-to-position", :type "action"}]},
                      :boxes-move-to-position
                                              {:type "parallel",
                                               :data
                                                     [{:to {:bezier [{:x 256, :y 640} {:x 205, :y 930}], :duration 0.7}, :type "transition", :transition-id "box1"}
                                                      {:to {:bezier [{:x 395, :y 758} {:x 410, :y 985}], :duration 0.7}, :type "transition", :transition-id "box2"}
                                                      {:to {:bezier [{:x 570, :y 680} {:x 610, :y 955}], :duration 0.7}, :type "transition", :transition-id "box3"}]},
                      :boxes-reset-position
                                              {:type "parallel",
                                               :data
                                                     [{:type "set-attribute", :target "box1", :attr-name "x", :attr-value 420}
                                                      {:type "set-attribute", :target "box1", :attr-name "y", :attr-value 595}
                                                      {:type "set-attribute", :target "box2", :attr-name "x", :attr-value 420}
                                                      {:type "set-attribute", :target "box2", :attr-name "y", :attr-value 595}
                                                      {:type "set-attribute", :target "box3", :attr-name "x", :attr-value 420}
                                                      {:type "set-attribute", :target "box3", :attr-name "y", :attr-value 595}]},
                      :boxes-show-up
                                              {:type "parallel",
                                               :data
                                                     [{:data
                                                             [{:type "set-attribute", :target "box1", :attr-name "type", :attr-value "animation"}
                                                              {:type "empty", :duration 100}
                                                              {:id "come2", :type "animation", :target "box1"}
                                                              {:id "idle2", :loop true, :type "add-animation", :target "box1"}],
                                                       :type "sequence-data"}
                                                      {:data
                                                             [{:type "set-attribute", :target "box2", :attr-name "type", :attr-value "animation"}
                                                              {:type "empty", :duration 100}
                                                              {:id "come2", :type "animation", :target "box2"}
                                                              {:id "idle2", :loop true, :type "add-animation", :target "box2"}],
                                                       :type "sequence-data"}
                                                      {:data
                                                             [{:type "set-attribute", :target "box3", :attr-name "type", :attr-value "animation"}
                                                              {:type "empty", :duration 100}
                                                              {:id "come2", :type "animation", :target "box3"}
                                                              {:id "idle2", :loop true, :type "add-animation", :target "box3"}],
                                                       :type "sequence-data"}]},
                      :check-box-drop
                                              {:type "sequence-data",
                                               :data
                                                     [{:type        "set-variable",
                                                       :var-name    "current-box",
                                                       :from-params [{:param-property "target", :action-property "var-value"}]}
                                                      {:fail         "empty",
                                                       :type         "test-transitions-collide",
                                                       :success      "check-place-1",
                                                       :from-params  [{:param-property "target", :action-property "transition-1"}],
                                                       :transition-2 "box1-ph"}
                                                      {:fail         "empty",
                                                       :type         "test-transitions-collide",
                                                       :success      "check-place-2",
                                                       :from-params  [{:param-property "target", :action-property "transition-1"}],
                                                       :transition-2 "box2-ph"}
                                                      {:fail         "empty",
                                                       :type         "test-transitions-collide",
                                                       :success      "check-place-3",
                                                       :from-params  [{:param-property "target", :action-property "transition-1"}],
                                                       :transition-2 "box3-ph"}]},
                      :check-current-slot
                                              {:type    "test-var-scalar",
                                               :success "correct",
                                               :fail    "mari-wrong",
                                               :from-var
                                                        [{:var-name "current-box", :action-property "var-name"} {:var-name "current-slot", :action-property "value"}]},
                      :check-place-1
                                              {:type     "test-var-scalar",
                                               :success  "check-current-slot",
                                               :fail     "mari-wrong",
                                               :from-var [{:var-name "current-box", :action-property "var-name"} {:var-name "letter1", :action-property "value"}]},
                      :check-place-2
                                              {:type     "test-var-scalar",
                                               :success  "check-current-slot",
                                               :fail     "mari-wrong",
                                               :from-var [{:var-name "current-box", :action-property "var-name"} {:var-name "letter2", :action-property "value"}]},
                      :check-place-3
                                              {:type     "test-var-scalar",
                                               :success  "check-current-slot",
                                               :fail     "mari-wrong",
                                               :from-var [{:var-name "current-box", :action-property "var-name"} {:var-name "letter3", :action-property "value"}]},
                      :correct                {:type "sequence-data", :data [{:id "mari-correct", :type "action"} {:id "next-task", :type "action"}]},
                      :empty                  {:type "empty", :duration 100},
                      :finish-activity
                                              {:type "sequence-data",
                                               :data
                                                     [{:id "pinata", :type "finish-activity"}
                                                      {:id "mari-hits-pinata-toward", :type "action"}
                                                      {:id "mari-hits-pinata-backward", :type "action"}
                                                      {:id "pinata-fall-down", :type "action"}
                                                      {:type "empty", :duration 2000}
                                                      {:type "scene", :scene-id "park"}]},
                      :get-new-boxes
                                              {:type "sequence-data",
                                               :data
                                                     [{:id "mari-hits-pinata-toward", :type "action"}
                                                      {:data
                                                             [{:id "mari-hits-pinata-backward", :type "action"}
                                                              {:id "pinata-hit", :type "action"}
                                                              {:id "boxes-jump-out", :type "action"}],
                                                       :type "parallel"}]},
                      :init-vars              {:type "parallel", :data [{:type "set-variable", :var-name "current-slot-number", :var-value 0}]},
                      :mari-hits-pinata-backward
                                              {:type "sequence-data",
                                               :data
                                                     [{:to            {:ease [1 1], :bezier [{:x 691, :y 500} {:x 1100, :y 420}], :duration 2},
                                                       :type          "transition",
                                                       :transition-id "mari"}]},
                      :mari-hits-pinata-toward
                                              {:type "sequence-data",
                                               :data
                                                     [{:to {:bezier [{:x 691, :y 636} {:x 513, :y 570}], :duration 1.3}, :type "transition", :transition-id "mari"}]},
                      :mari-says-task
                                              {:phrase             :current-task
                                               :phrase-description "Place current letter"
                                               :type               "sequence-data",
                                               :data
                                                                   [{:id "mari-voice-act-1", :type "action"}
                                                                    {:type "action", :from-var [{:var-name "current-slot", :var-property "mari-letter"}]}
                                                                    {:type "empty", :duration 700}
                                                                    {:id "mari-voice-act-2", :type "action"}
                                                                    {:type "action", :from-var [{:var-name "current-slot", :var-property "mari-letter"}]}
                                                                    {:id "mari-voice-act-3", :type "action"}]},
                      :mari-voice-act-1
                                              {:offset                 18.776,
                                               :phrase-text            "This is the letter"
                                               :phrase-text-translated "Esta es la letra",
                                               :start                  18.776,
                                               :type                   "animation-sequence",
                                               :duration               1.716,
                                               :audio                  "/raw/audio/l2/a11/L2_A11_Mari.m4a",
                                               :target                 "mari",
                                               :track                  1,
                                               :data                   [{:end 20.492, :anim "talk", :start 18.776}]},
                      :mari-voice-act-2
                                              {:offset                 21.737,
                                               :phrase-text            "Place the picture that starts with the letter"
                                               :phrase-text-translated "Coloca la foto que empieza con la letra",
                                               :start                  21.737,
                                               :type                   "animation-sequence",
                                               :duration               3.009,
                                               :audio                  "/raw/audio/l2/a11/L2_A11_Mari.m4a",
                                               :target                 "mari",
                                               :track                  1,
                                               :data                   [{:end 24.745, :anim "talk", :start 21.737}]},
                      :mari-voice-act-3
                                              {:offset                 25.313,
                                               :phrase-text            "on the title."
                                               :phrase-text-translated "sobre el piso",
                                               :start                  25.313,
                                               :type                   "animation-sequence",
                                               :duration               1.1,
                                               :audio                  "/raw/audio/l2/a11/L2_A11_Mari.m4a",
                                               :target                 "mari",
                                               :track                  1,
                                               :data                   [{:end 26.509, :anim "talk", :start 25.313}]},
                      :mari-voice-welcome
                                              {:offset                 0.677,
                                               :phrase                 :welcome
                                               :phrase-description     "Welcome"
                                               :phrase-text            "Hooray, we’re going to have a party with letters!!  When I hit the pinata, pictures will fall out.  Match the letters on the tile to the correct picture."
                                               :phrase-text-translated "Wiii, vamos a tener una fiesta con las letras! Cuando le pegue a la pinata, las fotos caeran. Empareja las letras sobre el piso a la foto correcta.",
                                               :start                  0.677,
                                               :type                   "animation-sequence",
                                               :duration               15.949,
                                               :audio                  "/raw/audio/l2/a11/L2_A11_Mari.m4a",
                                               :target                 "mari",
                                               :track                  1,
                                               :data                   [{:end 6.21, :anim "talk", :start 1.329}
                                                                        {:end 10.633, :anim "talk", :start 6.79}
                                                                        {:end 14.402, :anim "talk", :start 11.623}
                                                                        {:end 16.287, :anim "talk", :start 14.62}]},
                      :next-round
                                              {:type "sequence-data",
                                               :data
                                                     [{:type "set-variable", :var-name "current-slot-number", :var-value 0}
                                                      {:id "renew-current-concepts", :type "action"}
                                                      {:id "get-new-boxes", :type "action"}
                                                      {:id "set-concepts-data", :type "action"}
                                                      {:id "next-task", :type "action"}]},
                      :next-task
                                              {:type "sequence-data",
                                               :data
                                                     [{:type "counter", :counter-id "current-slot-number", :counter-action "increase"}
                                                      {:id "set-next-current-slot", :type "action"}
                                                      {:id "mari-says-task", :type "action"}]},
                      :pinata-fall-down
                                              {:type "sequence-data",
                                               :data
                                                     [{:id "empty", :type "animation", :target "pinata"}
                                                      {:id "empty_idle", :loop true, :type "add-animation", :target "pinata"}]},
                      :pinata-hit
                                              {:type "sequence-data",
                                               :data
                                                     [{:id "hit", :type "animation", :target "pinata"}
                                                      {:id "idle", :loop true, :type "add-animation", :target "pinata"}]},
                      :renew-current-concepts
                                              {:type "sequence-data",
                                               :data
                                                     [{:from        "assessment",
                                                       :type        "lesson-var-provider",
                                                       :on-end      "finish-activity",
                                                       :shuffled    false,
                                                       :variables   ["concept-1" "concept-2" "concept-3"],
                                                       :provider-id "words-set"}
                                                      {:from      ["concept-1" "concept-2" "concept-3"],
                                                       :type      "vars-var-provider",
                                                       :shuffled  true,
                                                       :variables ["box1" "box2" "box3"]}
                                                      {:from      ["concept-1" "concept-2" "concept-3"],
                                                       :type      "vars-var-provider",
                                                       :shuffled  true,
                                                       :variables ["letter1" "letter2" "letter3"]}
                                                      {:from      ["concept-1" "concept-2" "concept-3"],
                                                       :type      "vars-var-provider",
                                                       :shuffled  true,
                                                       :variables ["slot1" "slot2" "slot3"]}]},
                      :set-concepts-data
                                              {:type "parallel",
                                               :data
                                                     [{:type       "set-slot",
                                                       :target     "box1",
                                                       :from-var   [{:var-name "box1", :var-property "image-src", :action-property "image"}],
                                                       :slot-name  "box1",
                                                       :attachment {:x 40, :scale-x 4, :scale-y 4}}
                                                      {:type       "set-slot",
                                                       :target     "box2",
                                                       :from-var   [{:var-name "box2", :var-property "image-src", :action-property "image"}],
                                                       :slot-name  "box1",
                                                       :attachment {:x 40, :scale-x 4, :scale-y 4}}
                                                      {:type       "set-slot",
                                                       :target     "box3",
                                                       :from-var   [{:var-name "box3", :var-property "image-src", :action-property "image"}],
                                                       :slot-name  "box1",
                                                       :attachment {:x 40, :scale-x 4, :scale-y 4}}
                                                      {:type      "set-attribute",
                                                       :target    "letter1",
                                                       :from-var  [{:var-name "letter1", :var-property "letter", :action-property "attr-value"}],
                                                       :attr-name "text"}
                                                      {:type      "set-attribute",
                                                       :target    "letter2",
                                                       :from-var  [{:var-name "letter2", :var-property "letter", :action-property "attr-value"}],
                                                       :attr-name "text"}
                                                      {:type      "set-attribute",
                                                       :target    "letter3",
                                                       :from-var  [{:var-name "letter3", :var-property "letter", :action-property "attr-value"}],
                                                       :attr-name "text"}]},
                      :set-next-current-slot
                                              {:type "sequence-data",
                                               :data
                                                     [{:fail
                                                                 {:fail
                                                                            {:fail     "next-round",
                                                                             :type     "test-var-scalar",
                                                                             :value    3,
                                                                             :success
                                                                                       {:type "set-variable", :from-var [{:var-name "slot3", :action-property "var-value"}], :var-name "current-slot"},
                                                                             :var-name "current-slot-number"},
                                                                  :type     "test-var-scalar",
                                                                  :value    2,
                                                                  :success
                                                                            {:type "set-variable", :from-var [{:var-name "slot2", :action-property "var-value"}], :var-name "current-slot"},
                                                                  :var-name "current-slot-number"},
                                                       :type     "test-var-scalar",
                                                       :value    1,
                                                       :success
                                                                 {:type "set-variable", :from-var [{:var-name "slot1", :action-property "var-value"}], :var-name "current-slot"},
                                                       :var-name "current-slot-number"}]},
                      :start-scene            {:type "sequence", :data ["start-activity" "init-vars" "mari-voice-welcome" "next-round"]},
                      :start-activity         {:type "start-activity", :id "pinata"},
                      :stop-activity          {:type "stop-activity", :id "pinata"}
                      :init-audio-correct     {:type "sequence-data"
                                               :data [{:type "set-variable" :var-name "audio-correct1" :var-value "mari-audio-correct-1"}
                                                      {:type "set-variable" :var-name "audio-correct2" :var-value "mari-audio-correct-2"}
                                                      {:type "set-variable" :var-name "audio-correct3" :var-value "mari-audio-correct-3"}
                                                      {:type "set-variable" :var-name "audio-correct4" :var-value "mari-audio-correct-4"}
                                                      {:type "set-variable" :var-name "audio-correct5" :var-value "mari-audio-correct-5"}]}

                      :init-audio-try-again   {:type "sequence-data"
                                               :data [{:type "set-variable" :var-name "audio-try-again1" :var-value "mari-audio-try-again-1"}
                                                      {:type "set-variable" :var-name "audio-try-again2" :var-value "mari-audio-try-again-2"}]}

                      :mari-correct           {:phrase             :correct-answer
                                               :phrase-description "Correct answer"
                                               :type               "sequence-data"
                                               :data               [{:type "action" :id "init-audio-correct"}
                                                                    {:type      "vars-var-provider"
                                                                     :variables ["current-audio-correct"]
                                                                     :from      ["audio-correct1" "audio-correct2" "audio-correct3" "audio-correct4" "audio-correct5"]
                                                                     :shuffled  true}
                                                                    {:type "action" :from-var [{:var-name        "current-audio-correct" :action-property "id"
                                                                                                :possible-values [:mari-audio-correct-1
                                                                                                                  :mari-audio-correct-2
                                                                                                                  :mari-audio-correct-3
                                                                                                                  :mari-audio-correct-4
                                                                                                                  :mari-audio-correct-5]}]}]}

                      :mari-wrong             {:phrase             :wrong-answer
                                               :phrase-description "Wrong answer"
                                               :type               "sequence-data"
                                               :data               [{:type "action" :id "init-audio-try-again"}
                                                                    {:type      "vars-var-provider"
                                                                     :variables ["current-audio-try-again"]
                                                                     :from      ["audio-try-again1" "audio-try-again2"]
                                                                     :shuffled  true}
                                                                    {:type "action" :from-var [{:var-name        "current-audio-try-again" :action-property "id"
                                                                                                :possible-values [:mari-audio-try-again-1
                                                                                                                  :mari-audio-try-again-2]}]}]}

                      :mari-audio-correct-1   {:type        "animation-sequence",
                                               :target      "mari",
                                               :track       1,
                                               :offset      0.858,
                                               :audio       "/raw/audio/l1/a5/Mari_Coaching_statements.m4a",
                                               :start       0.858,
                                               :duration    1.837,
                                               :data        [{:start 1.052, :end 2.505, :duration 1.453, :anim "talk"}],
                                               :phrase-text "That’s correct!"}

                      :mari-audio-correct-2   {:type        "animation-sequence",
                                               :target      "mari",
                                               :track       1,
                                               :offset      4.697,
                                               :audio       "/raw/audio/l1/a5/Mari_Coaching_statements.m4a",
                                               :start       4.697,
                                               :duration    1.358,
                                               :data        [{:start 4.867, :end 5.926, :duration 1.059, :anim "talk"}],
                                               :phrase-text "Good job!"}

                      :mari-audio-correct-3   {:type        "animation-sequence",
                                               :target      "mari",
                                               :track       1,
                                               :offset      7.949,
                                               :audio       "/raw/audio/l1/a5/Mari_Coaching_statements.m4a",
                                               :start       7.949,
                                               :duration    1.345,
                                               :data        [{:start 8.066, :end 9.098, :duration 1.032, :anim "talk"}],
                                               :phrase-text "Well done!"}

                      :mari-audio-correct-4   {:type        "animation-sequence",
                                               :target      "mari",
                                               :track       1,
                                               :offset      10.997,
                                               :audio       "/raw/audio/l1/a5/Mari_Coaching_statements.m4a",
                                               :start       10.997,
                                               :duration    1.147,
                                               :data        [{:start 11.119, :end 11.964, :duration 0.845, :anim "talk"}],
                                               :phrase-text "You got it!"}

                      :mari-audio-correct-5   {:type        "animation-sequence",
                                               :target      "mari",
                                               :track       1,
                                               :offset      14.463,
                                               :audio       "/raw/audio/l1/a5/Mari_Coaching_statements.m4a",
                                               :start       14.463,
                                               :duration    2.333,
                                               :data        [{:start 14.611, :end 15.11, :duration 0.499, :anim "talk"}
                                                             {:start 15.529, :end 16.676, :duration 1.147, :anim "talk"}],
                                               :phrase-text "Wow, excelent!"}

                      :mari-audio-try-again-1 {:type        "animation-sequence",
                                               :target      "mari",
                                               :track       1,
                                               :offset      18.915,
                                               :audio       "/raw/audio/l1/a5/Mari_Coaching_statements.m4a",
                                               :start       18.915,
                                               :duration    1.493,
                                               :data        [{:start 18.983, :end 20.242, :duration 1.259, :anim "talk"}],
                                               :phrase-text "Try again!"}

                      :mari-audio-try-again-2 {:type        "animation-sequence",
                                               :target      "mari",
                                               :track       1,
                                               :offset      22.155,
                                               :audio       "/raw/audio/l1/a5/Mari_Coaching_statements.m4a",
                                               :start       22.155,
                                               :duration    3.025,
                                               :data        [{:start 23.743, :end 25.055, :duration 1.312, :anim "talk"}],
                                               :phrase-text "Hmmmm. Try again."}},
           :triggers {:stop {:on "back", :action "stop-activity"}, :start {:on "start", :action "start-scene"}},
           :metadata {:prev "park", :autostart true}})
