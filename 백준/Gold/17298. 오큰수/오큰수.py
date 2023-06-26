
num = int(input())
nums = list(map(int,input().split(' ')))
answer = [-1]*num
b = []

b.append(0)
for i in range(1,num):
    while b and nums[b[-1]] < nums[i]:
        answer[b.pop()] = nums[i]
    b.append(i)
print(*answer)