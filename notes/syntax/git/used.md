> ignored file、untracked file、tracked file、committed but ignored file、modified file、unstaged file、staged file、committed file

### git remote -v

查看所有remote服务器的fetch和push

### git remote rename {name}

重命名name服务器

### git remote remove {name}

删除远程的name服务器

### git remote set-url {name} {new url}

更新name服务器的fetch和push的url

---

### git add -i

--interactive，交互式暂存，太好用了叭，当无意中暂存了很多文件，需要分批 commit 的时候，再不用敲很长的文件名一个个 --staged 了

### git restore --staged FILE

将文件**从暂存区移出到工作区**，并不会删除文件、任何修改

### git restore FILE

忽略（删除） working dir 对此文件的修改，rollback。FILE为 tracked file

---

### git stash [push -m "msg"]

将**暂存区**的内容 push 到贮藏栈，再重置暂存区回到上次 commit 后的状态（默认是重置，往下看）。可以加个 msg，方便查找，默认是上次 commit 的 msg。advanced 选项

*-k|--keep-index|--no-keep-index* 选项，前二不重置暂存区，--no-keep-index （默认行为）重置暂存区

*-u|--include-untracked* 选项可以一同存储 untracked files

*-q|--quiet* 安静

同时 save 也可以，不过 save 被计划弃用。push 新加了 *pathspecs*，具体路径（路径规范）。而且对于栈的使用，push 更好理解不是吗 : )

### git stash list

列出从栈顶到栈底的所有 stash、对应 stash 所在分支、 msg

### git stash show [stash@{x}]

列出对应stash（默认最近一次stash，即栈顶stash）内容**和上次 commit 后的文件差异**——i 和 d 的简略表达方式，而不是工作区

### git stash pop|apply [stash@{x}]

pop-应用并删除，apply-仅应用，都默认栈顶的 stash，默认暂存区。另外应用贮藏的时候，很容i想到，当前的暂存区不能有暂存，不然无法应用。advanced 选项

*--index* 不使用这个选项的话有个细节就是，pop 之前暂存区 modified 状态的文件（不含tracked new file）会回到工作区，使用这个选项不会。

*-q|--quiet* 安静

### git stash drop stash@{x}

配合上面的 apply

---

### git pull

前提，当前分支存在上游分支

### git checkout -b feat origin/feat

拉取origin的feat分支到本地，并切换过去

### git push --set-upstream origin main

push 到 origin 的 main 分支，并将其设为上游分支

### git push origin :refs/tags/{tag name}

删除远程origin上的一个tag

### git push origin :{branch name}

删除远程origin上的一个分支

---

### git commit -am 'msg'

将 working tree 的全部操作添加到暂存区，再使用 commit message 的 short syntax 提交

### git commit -a --amend --no-edit

将 working tree 的全部操作添加到暂存区，且不修改 commit message 立即重写上次提交

---

### git filter-branch --tree-filter 'rm -f a.txt' HEAD

执行完毕返回类似

```tex
Rewrite e21c28a0dc3700adef52b9881102e5a6c17ea295 ...
Ref 'refs/heads/main' was rewritten
```

即 refs/heads/main 被重写，表示 filter 成功。

当下次再执行 git filter-branch 命令时，可能被告知

```tex
Cannot create a new backup.
A previous backup already exists in refs/original/
Force overwriting the backup with -f
```

当确定安全时，可以强制，使用 -f，此时可以 > git filter-branch -f --tree-filter 'rm -f a.txt' HEAD。

更具体的做法是： 该 refs/heads/main 是在 .git/refs/original 文件夹下， 找到branch_next_loc。

执行> git update-ref -d refs/original/refs/heads/{branch_next_loc} SHA 再执行 git filter-branch ...

SHA 值可以从上述 .git/refs/original/refs/heads/{branch_next_loc} 文件中找，当然可以直接删除这个文件，如果不需要它或者不喜欢 CLI