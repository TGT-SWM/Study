class Solution {
    let TBL: [Character: Int] = [
        "I": 1, "V": 5, "X": 10, "L": 50,
        "C": 100, "D": 500, "M": 1000
    ]
    
    func romanToInt(_ s: String) -> Int {
        var stack: [Int] = []
        for c in s {
            if stack.isEmpty || stack.last! >= TBL[c]! {
                stack.append(TBL[c]!)
            } else {
                stack.append(TBL[c]! - stack.popLast()!)
            }
        }
        
        return stack.reduce(0, +)
    }
}