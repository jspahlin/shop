GET	/product - get all products
POST	/product - Add new single product (employee)
PUT	/product - Add stock (or modify price?)

GET	/product/search/<stuff> - Search for the given string.

GET	/invoice/ - List all invoices
PUT	/invoice/approve
PUT	/invoice/deny

GET	/card
POST	/card
PUT	/card/{id}


GET	/employee/ - List all employees
POST	/employee/ - Create an employee
PUT	/employee/ - Update an employee

xGET	/login/ - current session
xPOST	/login/ - log in a user given username/pass

xPOST	/account/login - create an account (not a customer)
xPUT	/account/login - update an account into a customer.
	BODY {"billingAddress": "blah", "shippingAddress": "blah"}
PUT	/account/employee - update an account into an employee.
PUT	/account/admin - update an account into an admin.

GET	/cart - list all items in current session user's cart.
POST	/cart - Add a single invoiceline to the cart.
DELETE	/cart - Remove a single invoiceline (by it's id) from the cart.
UPDATE	/cart - Change the amount of an item in an invoice line that's in the cart.

xGET	/card/color - list of all card colors

xGET	/card/type - list of all card types

XGET	/card/rarity - list of all rarities

xGET	/card/Set - list of all card sets

XGET	/card/creature_type - list of all creature types.
