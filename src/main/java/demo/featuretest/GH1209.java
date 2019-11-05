package demo.featuretest;

import act.controller.annotation.UrlContext;
import act.util.Async;
import act.util.ProgressGauge;
import org.osgl.mvc.annotation.GetAction;

@UrlContext("1209")
public class GH1209 {

    @Async
    @GetAction
    public int asyncTest(ProgressGauge gauge) throws Exception {
        int sum = 0;
        final int count = 100;
        gauge.updateMaxHint(count);
        for (int i = 0; i < count; ++i) {
            sum += i;
            Thread.sleep(10);
            gauge.step();
        }
        return sum;
    }

}
