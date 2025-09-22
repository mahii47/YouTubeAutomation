Feature: YouTube Video Search and Comment Collection

  Scenario: Search and play a video, skip ads, and collect comments
    Given I launch the browser
    And I navigate to the YouTube website
    When I search for the video titled "Selenium tutorial"
    Then I should see the search results
    And I play the video from the "edureka!" channel
    And I skip any YouTube ads if they appear
    And I mute the YouTube video
    Then I collect all the comments from the video
    And I close the browser
