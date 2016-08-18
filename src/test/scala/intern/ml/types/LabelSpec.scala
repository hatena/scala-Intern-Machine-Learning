package intern.ml
package types

import org.scalatest.{FunSpec, Matchers, OptionValues, Inside, Inspectors}

class LabelSpec extends FunSpec with Matchers
    with OptionValues with Inside with Inspectors {
  describe("Label") {
    it("should not have any other instance than Positive or Negative") {
      assertTypeError("new Label(1)")
    }

    it("should return whether it is positive") {
      Label.Positive.positive shouldBe true
      Label.Negative.positive shouldBe false
    }

    it("should return whether it is negative") {
      Label.Positive.negative shouldBe false
      Label.Negative.negative shouldBe true
    }

    it("should convert an integer value") {
      Label.Positive.toInt shouldBe 1
      Label.Negative.toInt shouldBe -1
    }
  }
}
