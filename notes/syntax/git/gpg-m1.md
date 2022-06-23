# install

```shell
# install
brew install gpg

# install support
brew install gnupg pinentry-mac

# verify support;
gpgconf

#  "pinentry:Passphrase" must point to "pinentry-mac"; otherwise execute this
echo "pinentry-program /opt/homebrew/bin/pinentry-mac" >> ~/.gnupg/gpg-agent.conf

# test gpg; Ok if appear the window and need you input the Passphrase.
echo "test" | gpg --clearsign
```

# configure git & github

```shell
# generate key
LANGUAGE=en gpg --full-generate-key

# find the id of above key; KEY ID at "sec" line
gpg --list-secret-keys --keyid-format LONG

# get ascii pubKey and paste to github
gpg --armor --export KEYID | pbcopy

# configure git
git config --global gpg.program $(which gpg)
git config --global user.signingkey KEYID

# change directory to your repo(or set it with global config)
git config --local commit.gpgsign true

```

# configure IDEA

In the Settings/Preferences, go to Version Control | Git, and click the Configure GPG Key, select it!

# reference

[set-up-GPG-commit-signing](https://www.jetbrains.com/help/idea/2022.2/set-up-GPG-commit-signing.html)

[Git Tools - Signing Your Work](https://git-scm.com/book/en/v2/Git-Tools-Signing-Your-Work)