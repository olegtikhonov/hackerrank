## Bit manipulations

#### Reverse bits

```code
for(int i = 0; inx < 32; inx++) {
    bit = (n >> inx) & 1;
    res = res | (bit << (31 - i))
} 
```

#### Number of 1 bits
We can check if our most significant bit is 1 or 0, by & 1 operation. i.e. 1 0 1 1 & 0 0 0 1 = 0 0 0 1. From now on,
we have to shit right N and check again, counting our 1's.


```code 
while(n >= 0) {
    res += n % 2; //the same as & mask 1
    n = n >> 1;   // shift right
}
```

[solution](../hackerrank/src/main/java/test/twest/leetcode/EasyCalculate1Bits.java)

