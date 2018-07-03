GET	/product - get all products
POST	/product - Add new single product (employee)
PUT	/product - Add stock (or modify price?)

GET	/product/search/<stuff> - Search for the given string.

GET	/invoice/ - List all invoices
PUT	/invoice/approve
PUT	/invoice/deny


GET	/employee/ - List all employees
POST	/employee/ - Create an employee
PUT	/employee/ - Update an employee

GET	/login/ - current session
POST	/login/ - log in a user given username/pass

POST	/account/new - create an account

GET	/cart - list all items in current session user's cart.
POST	/cart - Add a single invoiceline to the cart.
DELETE	/cart - Remove a single invoiceline (by it's id) from the cart.
UPDATE	/cart - Change the amount of an item in an invoice line that's in the cart.
