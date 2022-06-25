class Solution {
    let MATCH: [Character: Character] = ["(": ")", "{": "}", "[": "]"]
    
    func isValid(_ s: String) -> Bool {
        var stack: [Character] = []
        for c in s {
            if MATCH.keys.contains(c) {
                stack.append(c)
            } else if stack.isEmpty {
                return false
            } else if MATCH[stack.last!]! != c {
                return false
            } else {
                stack.removeLast()
            }
        }
        
        return stack.isEmpty ? true : false
    }
}