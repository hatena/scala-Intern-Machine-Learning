package slearn

package object types {
  type Feature = Double
  type Features = Seq[Double]
  type TrainingSet = Seq[(Features, Label)]
  type Accuracy = Double
}
