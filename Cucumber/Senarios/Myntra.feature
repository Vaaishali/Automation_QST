Feature: Search

  @positive @sanity @all
  Scenario Outline: Verify Functionality of search by providing valid data.
    Given Launch an chrome browser.
    And user navigate to myntra site.
    When user Enter "<Search>" data in search box and submit it.
    Then user check page title based on search result "<Expected title>"
    And close chrome browser.

    Examples: 
      | Search     | Expected title                                              |
      | watch      | Watch - Buy Watch online in India                           |
      | shirt      | Shirt - Buy Shirt online in India                           |
      | sunglasses | Shop for Sunglasses Online in India                         |
      | saree      | Sarees (साड़ी) - Buy Latest Sari Collection Online in India |
      | shoes      | Shops the Latest Shoes for Men, Women & Kids Online          |
