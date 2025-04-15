#include <iostream>
#include <vector>
using namespace std;

class SegmentTree {
    vector<int> tree;
    int n;

public:
    SegmentTree(vector<int>& arr) {
        n = arr.size();
        tree.resize(2 * n);
        build(arr);
    }

    void build(vector<int>& arr) {
        for (int i = 0; i < n; i++) tree[n + i] = arr[i];
        for (int i = n - 1; i > 0; --i) tree[i] = tree[i << 1] + tree[i << 1 | 1];
    }

    void update(int pos, int value) {
        pos += n;
        tree[pos] = value;
        while (pos > 1) {
            pos >>= 1;
            tree[pos] = tree[pos << 1] + tree[pos << 1 | 1];
        }
    }

    int query(int l, int r) {
        l += n; r += n;
        int sum = 0;
        while (l < r) {
            if (l & 1) sum += tree[l++];
            if (r & 1) sum += tree[--r];
            l >>= 1; r >>= 1;
        }
        return sum;
    }
};

int main() {
    vector<int> nums = {1, 3, 5, 7, 9, 11};
    SegmentTree st(nums);
    cout << "Sum of range [1, 5): " << st.query(1, 5) << endl;
    st.update(1, 10);
    cout << "After update, sum of range [1, 5): " << st.query(1, 5) << endl;
}
