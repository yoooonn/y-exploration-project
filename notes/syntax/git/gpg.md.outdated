> 提交verified code，需要安装gpg

```bash
# 在此之前, 应该熟悉shell类型和shell环境, 清楚.profile、.zshrc等文件的作用、相同点、不同点

brew install gpg

# 执行之后看是否提示执行
brew link gnupg

# version at least 2.1.17, 执行下面命令生成key,
# 该过程有多步, 最后一步骤是在弹窗输入密码, 如果弹窗有乱码,
# command c 终止后先执行 echo 'export LC_ALL=en_US.UTF-8' >> ~/.zshrc && source ~/.zshrc
# 再执行下行命令, 然后按照步骤生成key, 其中keysize选4096（GitHub规定至少4096）
LANGUAGE=en gpg --full-generate-key

# 查找本机的私钥, key id按给定格式显示
# gpg --list-secret-keys --keyid-format LONG

# 如果输出为, 则说明key id是: 7B361397220D5CCC
# sec   rsa4096/7B361397220D5CCC 2021-02-26 [SC] [expires: 2021-07-26]
#       C54D0B2AFB512B980BFFA33D7B361397220D5CCC
# uid                 [ultimate] yooonn (The key expires in five months.) <ycourlee@qq.com>
# ssb   rsa4096/ADE49A4E97194952 2021-02-26 [E] [expires: 2021-07-26]

# export pub key to paste plate，拷贝生成的私钥
gpg --armor --export KEYID | pbcopy

# 然后粘贴刚刚复制的gpgkey到github账户

# 再设置tty
echo 'export GPG_TTY=$(tty)' >> ~/.zshrc && source ~/.zshrc

# 指定当前vcs的sign key
git config user.signingkey KEY_ID

# 即可
git commit -aSm '..'

# 再
git push

# 如果是经常push的项目或认为必须sign的项目，可以将sign commit的行为添加默认，本人是不太喜欢设置全局的config，除了name、email
git config --local commit.gpgsign true
```

NOTE:

关于弹窗乱码：应该是mac locale language（它和系统UI使用的语言无关）是中文的原因，导致brew安装的gpg是符合i81n且翻译到中文的，弹出输入secure passphrase的框是乱码的。在生成key的最后一步会出现弹窗，其实能猜出来输入逻辑，输入一次，再输入一次相，去确认，就成功了。

解决乱码在上文，如果未成功 可`sudo languagesetup`输入选项English的序号1，选择English

事实上，在设置`echo 'export LC_ALL=en_US.UTF-8' >> ~/.zshrc && source ~/.zshrc`之后再执行brew install install, 体验更好。

```text
Sign commits with GPG keys
Last modified: 26 July 2021
JetBrains Rider relies on the built-in GPG commit signing feature of Git. To get the best experience, we recommend using a gpg2 package with a graphical interface for handling passphrase prompts.

Configure the environment
Windows
macOS
Linux
Set up GPG support
Do one of the following:
Download and install GPGTools. Pre-configured GPG is part of the package.
Make sure that git config gpg.program points to the gpg file from the package (by default, the path is /usr/local/MacGPG2/bin/gpg).

Download and open Homebrew and run the following command: brew install gnupg pinentry-mac.
To verify everything is set up correctly, open GitBash, run the pgpconf command and make sure the output is like the following:

pg:OpenPGP:/usr/local/MacGPG2/bin/gpg
gpg-agent:Private Keys:/usr/local/MacGPG2/bin/gpg-agent
scdaemon:Smartcards:/usr/local/MacGPG2/libexec/scdaemon
gpgsm:S/MIME:/usr/local/MacGPG2/bin/gpgsm
dirmngr:Network:/usr/local/MacGPG2/bin/dirmngr
pinentry:Passphrase Entry:/usr/local/bin/pinentry-mac
Copied!
Make sure the pinentry shows a GUI prompt by running the echo GETPIN | pinentry command.

Set up GPG keys
The most secure way is to use smartcards, for example, Yubikey to store the private part of your keys. See YubiKey-Guide for instructions on how to set up Yubikey.

Import GPG keys
If you already have GPG keys, you need to import them to the respective GPG keyring.

Open Terminal / Command Prompt / GitBash / any other shell you have on your system and run the following command: --import <path to your private gpg.key>

Generate GPG keys
If there are no keys yet, you need to generate a new pair.

Open Terminal / Command Prompt / GitBash / any other shell you have on your system and run the following command: gpg --full-generate-key (for pgp 2.1.17 and below, use the gpg --gen-key command.

Answer the questions that the tool will return. The recommended choices are:

Type of the key: RSA

Key size: at least 4096 bits

Key validity period: 1 year (it's a good practice to rotate the key once a year)

Enter your user ID information. It is recommended to use the same username and e-mail address that is shown as the author of your commits. Specify the GitHub noreply email address if you plan to use the signature along with the email address privacy features.

Enter a secure passphrase. Make sure you enter it in a dialog that should pop up rather than entering it in command line as it is important that GUI is used for such prompts.

Make sure the keys have been imported by running the following command: gpg --list-keys.

Enable commit signing
Start JetBrains Rider (or restart it to make sure it loads the changes you've made to your environment).

In the Settings/Preferences dialog ⌃⌥S, go to Version Control | Git and enable the Sign commits option.

Select the key you want to use from the list.

Now your every commit will be signed with the selected key.

Add GPG key to your account
If Git hosting you are using supports verification of GPG signing, upload the public part of your key there.

Follow the instructions for
```