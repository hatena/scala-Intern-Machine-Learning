package slearn

package object types {
  type Feature = Double
  type Features = Seq[Double]
  type DataSet = Seq[(Features, Label)]
}
