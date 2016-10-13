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
