;; Java Interoperability
;; http://java.ociweb.com/mark/clojure/article.html#JavaInterop

; java.lang - imported by default
; import classes
; also :import in ns macro
(import
  '(java.util Calendar GregorianCalendar)
  '(javax.swing JFrame JLabel))

(. java.util.Calendar APRIL)
(. Calendar APRIL) ; works if Calendar class was imported
java.util.Calendar/APRIL
Calendar/APRIL ; when was imported

; easy interop, so clojure doesn't provide for example abs method
; call static method
(. Math pow 2 4)
(Math/pow 2 4)

; invoke constructor
(def calendar (new GregorianCalendar 2008 Calendar/APRIL 16))
(def calendar (GregorianCalendar. 2008 Calendar/APRIL 16))

; caling instance methods
(. calendar add Calendar/MONTH 2)
(. calendar get Calendar/MONTH)
(.add calendar Calendar/MONTH 2)
(.get calendar Calendar/MONTH)

; chaing method calls
(. (. calendar getTimeZone) getDisplayName)
(.. calendar getTimeZone getDisplayName)
; there is also .? - breaks when some is null

; doto macro - ~ with in Basic - invoke many methods on the same object
(doto calendar
  (.set Calendar/YEAR 1981)
  (.set Calendar/MONTH Calendar/AUGUST)
  (.set Calendar/DATE 1))
(def formatter (java.text.DateFormat/getDateInstance))
(.format formatter (.getTime calendar))

; memfn macro - allow Java method to be treatead as first class function
; -> alternative to anonymous fn caling a Java method
; beginIndex is just placeholder to indicate airity of function (for overloaded)
(map #(.substring %1 %2) ["Moe" "Larry" "Curly"] [1 2 3])
(map (memfn substring beginIndex) ["Moe" "Larry" "Curly"] [1 2 3])
(map (memfn substring index) ["Moe" "Larry" "Curly"] [1 2 3])
(map (memfn substring _) ["Moe" "Larry" "Curly"] [1 2 3])


;;; Proxies
; proxy - extends given Java class -> implement callback methods in listeners


;;; Threads
; all clojure functions implements Runnable & Callable interface
(defn delayed-print [ms text]
  (Thread/sleep ms)
  (println text))

; Pass an anonymous function that invokes delayed-print
; to the Thread constructor so the delayed-print function
; executes inside the Thread instead of
; while the Thread object is being created.
(.start (Thread. #(delayed-print 1000 ", World!")))
(print "Hello")


;;; Exception Handling
; try, catch, finally, throw
(defn collection? [obj]
  (println "obj is a" (class obj))
  ; Clojure collections implement clojure.lang.IPersistentCollection
  (or (coll? obj)   ; Clojure collection?
      (instance? java.util.Collection obj))) ; Java collection?

(defn average [coll]
  (when-not (collection? coll)
    (throw (IllegalArgumentException. "expected a collection")))
  (when (empty? coll)
    (throw (IllegalArgumentException. "collection is empty")))
  ; Apply the + function to all the items in coll,
  ; then divide by the number of items in it.
  (let [sum (apply + coll)]
    (/ sum (count coll))))

(try
  (println "list average =" (average '(2 3)))
  (println "vector average =" (average [2 3]))
  (println "set average =" (average #{2 3}))

  (let [al (java.util.ArrayList.)]
    (doto al (.add 2) (.add 3))
    (println "ArrayList average =" (average al)))

  (println "string average =" (average "1 2 3 4"))

  (catch IllegalArgumentException e
    (println e)
;;     (.printStackTrace e)
  )
  (finally
    (println "in finally")))
