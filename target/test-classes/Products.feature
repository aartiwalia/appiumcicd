Feature: Product scenarios

Scenario Outline: Validate product info on products page
Given I am logged in
Then product is listed with title "<Title>" and price "<Price>"

Examples:
| Title                   | Price  |
| Sauce Labs Bolts T-Shirt| $15.99 |

Scenario Outline: Validate product info on product details page
Given I am logged in
When i click on product title "<Title>"
Then I should be navigated to Product details page with title "<Title>", price "<Price>" and desc "<Description>"

Examples:
| Title                   | Price  |    Description |
| Sauce Labs Backpack| $29.99 | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.|
