class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s:  # Handle empty string edge case
            return ""

        maxstr = ""  # Start with an empty string

        # Define the expand function *before* using it
        def expand(left, right):
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return s[left + 1:right]  # Return the longest palindrome substring found

        for i in range(len(s)):
            odd = expand(i, i)     # Case for odd-length palindromes
            even = expand(i, i + 1)  # Case for even-length palindromes

            if len(odd) > len(maxstr):
                maxstr = odd
            if len(even) > len(maxstr):
                maxstr = even

        return maxstr
