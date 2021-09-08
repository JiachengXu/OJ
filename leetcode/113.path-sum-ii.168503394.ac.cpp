/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<int> path;
        vector<vector<int>> paths;
        dfs(root, path, paths, sum);
        return paths;
    }
    
    void dfs(TreeNode* node, vector<int> &path, vector<vector<int>> &paths, int sum){
        if(!node) return;
        path.push_back(node->val);
        if(!node->left && !node->right && node->val == sum) paths.push_back(path);
        dfs(node->left, path, paths, sum - node->val);
        dfs(node->right, path, paths, sum - node->val);
        path.pop_back();
    }
};
