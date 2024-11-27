Feature: Manage Addresses

  Scenario Outline: Add and verify a new address
    Given I am logged in as a user with email "kmlyorymqdscfvdosa@poplk.com" and password "AaBbCc123"
    When I navigate to the addresses section
    And I create a new alias <alias> address <address> city <city> postal code <postal code> country <country> phone <phone>
    Then I can see new address
    Examples:
      | alias |  address   | city     | postal code | country        | phone      |
      | Home  | 123 Main Street | TestCity | 12345       | United Kingdom | 1234567890 |
