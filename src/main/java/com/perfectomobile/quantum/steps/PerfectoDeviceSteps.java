package com.perfectomobile.quantum.steps;

import com.perfectomobile.quantum.utils.DeviceUtils;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import cucumber.api.java.en.Then;

/**
 * The class PerfectoDeviceSteps provides methods for working with a device, with cucumber steps annotations. 
 * <p>
 * Example: Working with a device.
 * <pre>
 * Scenario: 
 * 	Given I go to the device home screen
 * 	Then I open browser to webpage "https://community.perfectomobile.com/"
 * 	Then I should see text "GETTING STARTED"
 * 	Then I take a screenshot and save to PRIVATE:dir1/dir2/name.png
 * </pre>
 * 
 * @author shanil
 * @see <a href="https://github.com/PerfectoCode/Quantum/wiki/BDD-Implementation">BDD Implementation</a>
 *
 */
@QAFTestStepProvider
public class PerfectoDeviceSteps {

    protected static QAFExtendedWebDriver getDriver(){
        return new WebDriverTestBase().getDriver();
    }

    /**
     * Rotates the device to landscape mode.
     */
    @Then("^I rotate the device to landscape$")
    public void rotateToLandscape(){
        DeviceUtils.rotateDevice(getDriver(), "landscape", "state");
    }

    /**
     * Rotates the device to portrait mode.
     */
    @Then("^I rotate the device to portrait$")
    public void rotateToPortrait() {
        DeviceUtils.rotateDevice(getDriver(), "portrait", "state");
    }

    /**
     * Rotates the device to its next state.
     */
    @Then("^I rotate the device$")
    public void rotateDevice() {
        DeviceUtils.rotateDevice(getDriver(), "next", "operation");
    }

    /**
     * Sets the device location using latitude,longitude coordinates (decimal degrees) format. This enables testing a location-aware app that uses Location Services, without moving the device from place to place to generate location data.
	 * <p>
     * Confirm that the "Allow mock locations" setting is enabled.
	 * Go to: Settings, Developer options, Allow mock locations.
 	 * <p>
     * Example: 43.642659,-79.387050
     * 
     * @param coordinates the location coordinates to set
     */
    @Then("^I set the device location to the coordinates \"(.*?)\"$")
    public void setLocationByCoordinates(String coordinates) {
        DeviceUtils.setLocation(getDriver(), coordinates, "coordinates");
    }

    /**
     * Sets the device location using address (Google Geocoding) format. This enables testing a location-aware app that uses Location Services, without moving the device from place to place to generate location data.
	 * <p>
     * Confirm that the "Allow mock locations" setting is enabled.
	 * Go to: Settings, Developer options, Allow mock locations.
 	 * <p>
     * Example: 1600 Amphitheatre Parkway, Mountain View, CA
     * 
     * @param address the location address to set
     */
    @Then("^I set the device location to the address \"(.*?)\"$")
    public void setLocationByAddress(String address){
        DeviceUtils.setLocation(getDriver(), address, "address");
    }

    /**
     * Checks the device location using latitude,longitude coordinates (decimal degrees) format. Stops the test in case of failure.
     * <p>
     * Example: 43.642659,-79.387050
     * 
     * @param coordinates the location coordinates to check
     */
    @Then("^the device coordinates must be \"(.*?)\"$")
    public void assertLocationCoordinates(String coordinates) {
        DeviceUtils.assertLocation(getDriver(), coordinates);
    }

    /**
     * Verifies the device location using latitude,longitude coordinates (decimal degrees) format. The test will continue to run in case of failure.
     * <p>
     * Example: 43.642659,-79.387050
     * 
     * @param coordinates the location coordinates to verify
     * @return <code>true</code> if the location is verified, <code>false</code> otherwise
     */
    @Then("^the device coordinates should be \"(.*?)\"$")
    public boolean verifyLocationCoordinates(String coordinates) {
        return DeviceUtils.verifyLocation(getDriver(), coordinates);
    }

    /**
     * Resets the device location. This command should be used after the setting the location to stop setting the device location.
     * <p>
	 * This operation returns the device to its current location.
     */
    @Then("^I reset the device location$")
    public void resetLocation(){
        DeviceUtils.resetLocation(getDriver());
    }

    /**
     * Brings the device to its idle / home screen. This is done by navigating the device back to the home screen.
	 * <p>
	 * For iOS and Android devices, the device is unlocked and returned to its default rotate orientation.
	 * <p>
	 * Use this command at the beginning of a script, to ensure a known starting point for the user.
     */
    @Then("^I go to the device home screen$")
    public void goToHomeScreen(){
        DeviceUtils.goToHomeScreen(getDriver());
    }

    /**
     * Performs the swipe gesture to the left.
     */
    @Then("^I swipe left$")
    public void swipeLeft(){
        DeviceUtils.swipe(getDriver(), "60%,50%", "10%,50%");
    }

    /**
     * Performs the swipe gesture to the right.
     */
    @Then("^I swipe right")
    public void swipeRight(){
        DeviceUtils.swipe(getDriver(), "40%,50%", "90%,50%");
    }

    /**
     * Performs the scroll up gesture.
     */
    @Then("^I scroll up$")
    public void scrollUp(){
        DeviceUtils.swipe(getDriver(), "50%,40%", "50%,60%");
    }

    /**
     * Performs the scroll down gesture.
     */
    @Then("^I scroll down$")
    public void scrollDown(){
        DeviceUtils.swipe(getDriver(), "50%,60%", "50%,40%");
    }

    /**
     * Locks the device screen for the duration set in seconds, and unlocks the device.
     * 
     * @param seconds the lock screen duration
     */
    @Then("^I lock the device for \"(\\d*\\.?\\d*)\" seconds$")
    public void lockDevice(int seconds){
        DeviceUtils.lockDevice(getDriver(), seconds);
    }

    /**
     * Sets the device timezone.
     * 
     * @param timezone the new timezone Id
     */
    @Then("^I set timezone to \"(.*?)\"")
    public void setTimezone(String timezone){
        DeviceUtils.setTimezone(getDriver(), timezone);
    }

    /**
     * Checks the device timezone. Stops the test in case of failure.
     * 
     * @param timezone the new timezone Id to check
     */
    @Then("^the device timezone must be \"(.*?)\"")
    public void assertTimezone(String timezone){
        DeviceUtils.assertTimezone(getDriver(), timezone);
    }

    /**
     * Verifies the device timezone. The test will continue to run in case of failure.
     * 
     * @param timezone the timezone Id to verify
     * @return <code>true</code> if the timezone is verified, <code>false</code> otherwise
     */
    @Then("^the device timezone should be \"(.*?)\"")
    public boolean verifyTimezone(String timezone){
        return DeviceUtils.verifyTimezone(getDriver(), timezone);
    }

    /**
     * Resets the device timezone Id to the default.
     */
    @Then("^I reset the device timezone$")
    public void resetTimezone(){
        DeviceUtils.resetTimezone(getDriver());
    }

    /**
     * Gets a digital screenshot of the current screen display, and places it in the report.
     */
    @Then("^I take a screenshot$")
    public void takeScreenshot(){
        DeviceUtils.takeScreenshot(getDriver(), null, false);
    }

    /**
     * Gets a digital screenshot of the current screen display, and saves it to the repository.
     * 
     * @param repositoryPath the full repository path, including directory and file name, where to save the file. Example - PRIVATE:dir1/dir2/name.png
     */
    @Then("^I take a screenshot and save to \"(.*?)\"$")
    public void takeScreenshot(String repositoryPath){
        DeviceUtils.takeScreenshot(getDriver(), repositoryPath, true);
    }

    /**
     * Hides the virtual keyboard display.
     */
    @Then("^I hide keyboard$")
    public void hideKeyboard(){
        DeviceUtils.hideKeyboard(getDriver());
    }


}
