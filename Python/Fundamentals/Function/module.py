def make_pizza(size, *toppings):  # positional arguments ( đối số vị trí ) bao giờ cũng đặt trước
    """Print the list of toppings that have been requested."""
    print(f"\nMaking a {size}-inch pizza required the following toppings:")
    for topping in toppings:
        print(f"- {topping}")