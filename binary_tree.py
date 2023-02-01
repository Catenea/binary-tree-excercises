class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


a = Node(1)
b = Node(2)
c = Node(3)
d = Node(4)
e = Node(5)
f = Node(6)


a.left = b
a.right = c
b.left = d
b.right = e
c.right = f


def breath_first_search(root, target):
    if root is None:
        return False
    values = [root]
    results = []
    while len(values) > 0:
        node = values.pop(0)
        if node.value == target:
            return True
        results.append(node.value)
        if node.left:
            values.append(node.left)
        if node.right:
            values.append(node.right)
    return False


def depth_first_search(root, target):
    if root is None:
        return False
    if root.value == target:
        return True
    return depth_first_search(root.left, target) or depth_first_search(
        root.right, target
    )


def sum_of_tree(root):
    if root is None:
        return 0
    return root.value + sum_of_tree(root.left) + sum_of_tree(root.right)


def min_value_of_tree(root):
    smallest = float("inf")
    if root is None:
        return smallest
    return min(root.value, min_value_of_tree(root.left), min_value_of_tree(root.right))


def max_sum_of_branch(root):
    if root is None:
        return 0
    return root.value + max(max_sum_of_branch(root.left), max_sum_of_branch(root.right))
