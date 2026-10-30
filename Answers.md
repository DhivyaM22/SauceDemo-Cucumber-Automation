## B1. Review AI-Generated Code

I have experience working with Java and Selenium. Since the given code was written using Playwright, I used AI to understand the code and identify the mistakes. After reviewing the code, I identified the following problems:

### Problems Identified

1. **Hard-coded URL:** The application URL is hard-coded instead of being maintained in a configuration file.
2. **Hard-coded credentials:** The username and password are directly written in the code instead of being stored in configuration or environment variables.
3. **Broad locator:** `text=Add to cart` is a broad locator and may select the wrong product.
4. **Only one product is added:** The test adds only one product, so it does not properly verify a multiple-product checkout scenario.
5. **Fixed wait:** `waitForTimeout(3000)` uses a fixed wait. This can make the test slow and unreliable. An explicit condition-based wait should be used.
6. **Cart verification is missing:** The code does not verify whether the selected products are successfully added to the cart.
7. **Unrealistic test data:** Customer details should use valid and meaningful test data.
8. **Checkout navigation is not verified:** The code does not check whether the user successfully reaches the checkout page.
9. **Subtotal and tax are not verified:** The code does not validate the item subtotal and tax values.
10. **Incorrect assertion:** `toBeTruthy()` only checks whether a value is present or truthy. It does not verify whether the checkout total is correct.
11. **Expected total is not calculated:** The expected total should be calculated independently using:

`Expected Total = Item Subtotal + Tax`

### Conclusion

By using AI to understand the Playwright code, I was able to identify issues related to locators, waits, test data, and validations. My practical experience with Java and Selenium helped me understand the importance of reliable automation and proper assertions.

## B2. Test an AI Feature

**Selected Scenario: Test Case Generator**

I selected the Test Case Generator because it is related to QA testing.

I would perform the following four checks:

| No. | Check | Scoring Method |
|---|---|---|
| 1 | Verify whether AI generates positive, negative, and boundary test cases. | By rubric |
| 2 | Verify whether AI creates requirements that are not mentioned in the user story. | Human review |
| 3 | Verify whether duplicate test cases are generated. | Automatically |
| 4 | Verify whether the output is valid JSON with all required fields. | Automatically |

These checks help ensure that AI generates useful, accurate, and properly formatted test cases.

## B3. Defect Report

**Title:** Products are displayed in the wrong order when sorting by Price (low to high).

### Environment
- Application: SauceDemo
- Release: 4.2.0
- Browser: Google Chrome

### Steps to Reproduce
1. Open SauceDemo.
2. Log in using valid credentials.
3. Navigate to the Products page.
4. Select the sorting dropdown.
5. Choose **Price (low to high)**.
6. Observe the product prices.

### Expected Result
Products should be displayed from the lowest price to the highest price. For example, $15.99 should appear before $29.99.

### Actual Result
The product priced at $29.99 appears before the product priced at $15.99.

- **Severity:** Major
- **Priority:** High
- **Reproducibility:** 100% (occurs on every test run, according to the assessment scenario).

**Reason:** Price sorting is not working correctly. This affects the user's ability to find products based on price.

### Evidence
- Screenshot showing the incorrect sorting order.
- Screen recording demonstrating the issue.
- Browser and application version details.

## B4. Client Communication

**To:** Project Manager / Release Manager

**CC:** Development Team Lead, QA Lead, Product Owner, Testing Team

Hi Team,

During testing, we identified an issue in the Price (low to high) sorting functionality. Products are displayed in the wrong order on every test run.

We also observed that the checkout test fails approximately 1 out of 10 times but passes when rerun. We need to investigate the reason for this intermittent failure.

I recommend holding the full release until the sorting issue is fixed and the checkout failure is investigated.

If the sorting feature can be disabled and a rollback plan is available, we can consider a limited release after reviewing the risks and getting approval.

I will share the testing results after the fixes are completed.

Regards,  
QA Team