class Solution {
    func isPalindrome(_ x: Int) -> Bool {
        let s = String(x)
        let rs = String(s.reversed())
        let n = s.count / 2 + 1
        return s.prefix(n) == rs.prefix(n)
    }
}