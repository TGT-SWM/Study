class Solution {
    func longestCommonPrefix(_ strs: [String]) -> String {
        var shortest = strs[0]
        for str in strs {
            if shortest.count > str.count {
                shortest = str
            }
        }
        
        var i = 0
        while i < shortest.count {
            var c = shortest[shortest.index(shortest.startIndex, offsetBy: i)]
            var allMatched = true
            for str in strs {
                var idx = str.index(str.startIndex, offsetBy: i)
                if str[idx] != c {
                    allMatched = false
                    break
                }
            }
            
            if !allMatched {
                break
            }
            i += 1
        }
        
        return String(shortest.prefix(i))
    }
}