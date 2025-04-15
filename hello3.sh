#!/bin/bash
echo "Hello, World! from Bash"

#!/bin/bash

fibonacci() {
    if [ $1 -le 1 ]; then
        echo $1
    else
        local prev1=$(fibonacci $(( $1 - 1 )))
        local prev2=$(fibonacci $(( $1 - 2 )))
        echo $(( prev1 + prev2 ))
    fi
}

echo "Fibonacci series up to 10 terms:"
for i in {0..9}; do
    fibonacci $i
done