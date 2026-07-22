#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
    struct Block {
        int type;  
        int start;
        int end;
        inline int len() const { return end - start + 1; }
    };

public:
    vector<int> maxActiveSectionsAfterTrade(string s, vector<vector<int>>& queries) {
        const int n = (int)s.size();
        const char* p = s.data();

        vector<Block> blocks;
        blocks.reserve(n);
        vector<int> block_id(n);

        int total_ones = 0;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && p[j] == p[i]) ++j;
            blocks.push_back({p[i] - '0', i, j - 1});
            fill(block_id.begin() + i, block_id.begin() + j, (int)blocks.size() - 1);
            if (p[i] == '1') total_ones += j - i;
            i = j;
        }

        const int K = (int)blocks.size();
        const int LOG = 32 - __builtin_clz((unsigned)K);
        vector<int> st((size_t)LOG * K, 0);
        for (int k = 1; k + 1 < K; ++k) {
            if (blocks[k].type == 1) {
                st[k] = blocks[k - 1].len() + blocks[k + 1].len();
            }
        }
        for (int j = 1; j < LOG; ++j) {
            const int half = 1 << (j - 1);
            const int span = 1 << j;
            const int* prev = &st[(size_t)(j - 1) * K];
            int* cur = &st[(size_t)j * K];
            for (int k = 0; k + span <= K; ++k) {
                cur[k] = max(prev[k], prev[k + half]);
            }
        }

        auto query_rmq = [&](int L, int R) -> int {
            if (L > R) return 0;
            int len = R - L + 1;
            int j = 31 - __builtin_clz((unsigned)len);
            const int* level = &st[(size_t)j * K];
            return max(level[L], level[R - (1 << j) + 1]);
        };

        vector<int> ans;
        ans.reserve(queries.size());

        for (const auto& q : queries) {
            const int L = q[0], R = q[1];
            const int id_L = block_id[L];
            const int id_R = block_id[R];

            int max_gain = 0;
            if (id_R - id_L >= 2) {
                max_gain = query_rmq(id_L + 2, id_R - 2);

                const bool touching = (id_R - id_L == 2);
                const int k1 = id_L + 1;
                const int k2 = id_R - 1;

                if (blocks[k1].type == 1) {
                    int left_len  = blocks[id_L].end - L + 1;             
                    int right_len = touching ? (R - blocks[id_R].start + 1)
                                              : blocks[k1 + 1].len();
                    max_gain = max(max_gain, left_len + right_len);
                }
                if (k2 != k1 && blocks[k2].type == 1) {
                    int left_len  = touching ? (blocks[id_L].end - L + 1)
                                              : blocks[k2 - 1].len();
                    int right_len = R - blocks[id_R].start + 1;          
                    max_gain = max(max_gain, left_len + right_len);
                }
            }

            ans.push_back(total_ones + max_gain);
        }

        return ans;
    }
};