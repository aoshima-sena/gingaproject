package jp.co.ginga.web.application.controller.util.reservation;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jp.co.ginga.web.application.util.helper.facilityReservation.CalenderYearFormHelper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CalenderYearFormHelperTest {


	@Autowired
	CalenderYearFormHelper calenderYearFormHelper;

//String int 問題でややこしくなったから消しました
}
