class TrieNode {
    constructor() {
        this.children = {};
        this.isEnd = false;
    }
}

class Trie {
    constructor() {
        this.root = new TrieNode();
    }

    insert(word) {
        let node = this.root;
        for (let char of word) {
            if (!node.children[char]) node.children[char] = new TrieNode();
            node = node.children[char];
        }
        node.isEnd = true;
    }

    search(word) {
        let node = this.root;
        for (let char of word) {
            if (!node.children[char]) return false;
            node = node.children[char];
        }
        return node.isEnd;
    }

    startsWith(prefix) {
        let node = this.root;
        for (let char of prefix) {
            if (!node.children[char]) return false;
            node = node.children[char];
        }
        return true;
    }
}

// Usage
const trie = new Trie();
trie.insert("chat");
trie.insert("chatgpt");
console.log("Search 'chat':", trie.search("chat"));       // true
console.log("Starts with 'cha':", trie.startsWith("cha")); // true
console.log("Search 'gpt':", trie.search("gpt"));         // false
