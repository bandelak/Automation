package support;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static support.Base.extentTest;

public class SoftAssertion extends SoftAssert {
    @Override
    public void onAssertSuccess(IAssert<?> assertCommand) {
        //test.log(Status.PASS, assertCommand.getMessage());
        extentTest.pass(assertCommand.getExpected().toString());
    }

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
        String str="Expected: "+assertCommand.getExpected().toString()+"<br/>Actual: "+assertCommand.getActual().toString();
        try {
            extentTest.fail(str, MediaEntityBuilder.createScreenCaptureFromPath(Events.getScreenshot()).build());
        } catch (IOException ioex) {
            System.out.println("problem with file:"+ioex);
        }
    }
}
