class Solution:
    def countServers(self, n, logs, x, queries):

        logs.sort(key=lambda a: a[1])

        q = sorted((queries[i], i) for i in range(len(queries)))

        ans = [0] * len(queries)

        freq = {}
        left = 0
        right = 0

        for time, idx in q:

            start = time - x

            while right < len(logs) and logs[right][1] <= time:
                server = logs[right][0]
                freq[server] = freq.get(server, 0) + 1
                right += 1

            while left < right and logs[left][1] < start:
                server = logs[left][0]

                freq[server] -= 1

                if freq[server] == 0:
                    del freq[server]

                left += 1

            ans[idx] = n - len(freq)

        return ans