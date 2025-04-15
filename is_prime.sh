#!/bin/bash

is_prime() {
    local n=$1
    if [ "$n" -le 1 ]; then
        echo "Not prime"
        return
    fi
    for ((i = 2; i * i <= n; i++)); do
        if ((n % i == 0)); then
            echo "Not prime"
            return
        fi
    done
    echo "Prime"
}

read -p "Enter number: " num
echo "Result: $(is_prime $num)"
