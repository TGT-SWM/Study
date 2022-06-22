class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var dict: [Int: Int] = [:]
        for i in 0..<nums.count {
            let n = nums[i]
            if dict[n] == nil {
                dict[target - n] = i
            } else {
                return [i, dict[n]!]
            }
        }
        return [-1, -1]
    }
}