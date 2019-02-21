(ns twenty48.core
  (:gen-class))

(def all-identicals
  (comp
   (partial partition-by identity)
   (partial remove zero?)))

(def split-by-2
  (comp
   (partial mapcat
            (partial partition-all 2))
   all-identicals))

(def add-splitted (partial (comp (partial map (partial reduce +)) split-by-2)))

(def zeros-count
  (comp
   (partial - 4)
   (partial count)
   add-splitted))

(defn prepend-zeros
  [coll]
  (concat (repeat (zeros-count coll) 0) (add-splitted coll)))

(defn append-zeros
  [coll]
  (concat (add-splitted coll) (repeat (zeros-count coll) 0)))

(defn move-grid-right
  [grid]
  (map prepend-zeros grid))

(defn move-grid-left
  [grid]
  (map append-zeros grid))

(defn move-grid-down
  [grid]
  (apply map vector (move-grid-right (apply map vector grid))))

(defn move-grid-up
  [grid]
  (apply map vector (move-grid-left (apply map vector grid))))
