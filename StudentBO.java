import org.springframework.stereotype.Component;

@Component

public class StudentBO {

    public float calculateFee(Student obj) throws InvalidGradeException {

        char grade = obj.getGrade();

        Hostel hostel = obj.getHostel();

        float rent = hostel.getRent();

        if (grade == 'C' || grade == 'F') {

            return rent;

        } else if (grade == 'O' || grade == 'D' || grade == 'A' || grade == 'B') {

            float discountPercentage = FeesDiscountDetails.getInstance().getFeesDiscount().get(String.valueOf(grade));

            if (discountPercentage == 0) {

                throw new InvalidGradeException("Invalid Grade");

            }

            float discountedRent = rent - (rent * discountPercentage / 100);

            return discountedRent;

        } else {

            throw new InvalidGradeException("Invalid Grade");

        }

    }

}
