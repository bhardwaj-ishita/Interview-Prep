class MinStack:

    def __init__(self):
        self.stack = []
        self.minElement = 0


    def push(self, val: int) -> None:
        if not self.stack:
            self.stack.append(val)
            self.minElement = val
        elif self.stack and self.minElement <= val:
            self.stack.append(val)
        elif self.stack and self.minElement > val:
            self.stack.append((2*val)-self.minElement)
            self.minElement = val

    def pop(self) -> None:
        if self.stack[-1] < self.minElement:
            self.minElement = (2*self.minElement) - self.stack[-1]    
        self.stack.pop()

    def top(self) -> int:
        if not self.stack:
            return -1
        elif self.stack and self.stack[-1] < self.minElement:
            return self.minElement
        else:
            return self.stack[-1]

    def getMin(self) -> int:
        if not self.stack:
            return -1
        return self.minElement

