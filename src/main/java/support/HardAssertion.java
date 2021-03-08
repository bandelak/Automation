package support;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;

import java.io.IOException;

import static support.Base.extentTest;

public class HardAssertion extends Assertion {
    @Override
    public void onAssertSuccess(IAssert<?> assertCommand) {
        //test.log(Status.PASS, assertCommand.getMessage());
        extentTest.pass(assertCommand.getExpected().toString());
    }

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
        extentTest.fail("Expected: "+assertCommand.getExpected().toString()+"<br/>+Actual: "+assertCommand.getActual().toString());
        /*String details="Actual:"+assertCommand.getActual()+" ; Expected:"+assertCommand.getExpected();
        try {
            //test.log(Status.FAIL, details, MediaEntityBuilder.createScreenCaptureFromPath(generics.getScreenshot()).build());
        } catch (IOException ioex) {
            System.out.println("problem with file");
        }*/
    }
}
