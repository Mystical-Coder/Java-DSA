#include <bits/stdc++.h>
using namespace std;

bool isPerfectSquare(long long val, long long& sqrtVal) {
    sqrtVal = (long long)sqrt((double)val);
    // Check around sqrt due to floating point precision
    for (long long x = max(1LL, sqrtVal - 1); x <= sqrtVal + 1; x++) {
        if (x * x == val) {
            sqrtVal = x;
            return true;
        }
    }
    return false;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, K;
    cin >> N >> K;
    
    map<long long, long long> freq;
    for (int i = 0; i < N; i++) {
        long long x;
        cin >> x;
        freq[x]++;
    }
    
    // Get sorted distinct values
    vector<long long> vals;
    for (auto& p : freq) {
        vals.push_back(p.first);
    }
    
    int M = vals.size();
    long long maxScore = 0;
    
    // Standard progressions: b, b^2, b^3, ...
    for (int i = 0; i < M; i++) {
        long long b = vals[i];
        if (b < 2) continue;
        
        int currentPos = i;
        long long currentValue = b;
        
        for (int step = 0; step < K; step++) {
            // Check overflow before multiplying
            if (currentValue > 1e18 / b) break;
            long long expectedValue = currentValue * b;
            
            // Binary search in suffix [currentPos, M-1]
            auto it = lower_bound(vals.begin() + currentPos, vals.end(), expectedValue);
            
            if (it == vals.end()) break;
            
            int p = it - vals.begin();
            
            if (vals[p] == expectedValue) {
                // Successful match - calculate score from BASE+1 to this match
                long long score = 0;
                for (int j = i + 1; j <= p; j++) {
                    score += freq[vals[j]];
                }
                maxScore = max(maxScore, score);
                currentPos = p;
                currentValue = expectedValue;
            } else {
                // No match - update position and continue
                currentPos = p;
                currentValue = expectedValue;
            }
        }
    }
    
    // Perfect square progressions: x^2, x^4, x^6, ...
    for (int i = 0; i < M; i++) {
        long long val = vals[i];
        long long x;
        
        if (!isPerfectSquare(val, x) || x < 2) continue;
        
        int currentPos = i;
        long long currentValue = val; // x^2
        
        for (int step = 0; step < K; step++) {
            // Multiply by x^2
            if (currentValue > 1e18 / x / x) break;
            long long expectedValue = currentValue * x * x;
            
            // Search in suffix [currentPos, M-1]
            auto it = lower_bound(vals.begin() + currentPos, vals.end(), expectedValue);
            
            if (it == vals.end() || *it != expectedValue) {
                // Not found - terminate immediately
                break;
            }
            
            int p = it - vals.begin();
            
            // Calculate score from START+1 to this match
            long long score = 0;
            for (int j = i + 1; j <= p; j++) {
                score += freq[vals[j]];
            }
            maxScore = max(maxScore, score);
            
            currentPos = p;
            currentValue = expectedValue;
        }
    }
    
    cout << maxScore << endl;
    
    return 0;
}
