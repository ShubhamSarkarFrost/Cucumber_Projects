Feature: As a User i want to verify basic search operation works in FirstCry Website

  Scenario Outline: Perform Global Search with <Search>
     Given I am on FirstCry Webpage
     When  I Enter the "<Search>" keyword in Global Search
     Then  I Verify the "<Search>" keyword is contained in the "<Result>"

    Examples:
      | Search | Result |
      |   baby toys |  Baby & Kids Toys and Games |
      |    girl toys |   Baby & Kids Toys and Games |
