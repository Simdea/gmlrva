Contributing to GMLRVA
======================

## Contributing Guide

Contributions are welcome and are greatly appreciated! Every little bit helps, and credit will always be given.

## Pull Request Guidelines

Before you submit a pull request from your forked repo, check that it meets these guidelines:
1. Create a feature branch
2. When the feature is done, please run (`./gradlew check`) to ensure the code respects our style guidelines.
3. If the pull request adds functionality, edit the sample app to demonstrates the new functionality.
4. If the pull request fixes a bug, create a new [issue](https://github.com/simdea/gmlrva/issues/new) with an explanation including what the bug was, and how to reproduce, then reference the issue in PR description.
5. Create PR when you're done.

## DO and DON'Ts

* **DO** include tests when adding new features. When fixing bugs, start with adding a test that highlights how the current behavior is broken.
* **DO** keep the discussions focused. When a new or related topic comes up it's often better to create new issue than to side track the discussion.
* **DO** submit all code changes via pull requests (PRs) rather than through a direct commit. PRs will be reviewed and potentially merged by the repo maintainers after a peer review that includes at least one maintainer.
* **DO** give PRs short-but-descriptive names (e.g. "Improve code coverage for xpto by 10%", not "Fix #23")
* **DO** tag any users that should know about and/or review the change.
* **DO** ensure each commit successfully builds.
* **DO** run check validator (`./gradlew check`) when submiting PRs.
* **DO** fix merge conflicts using a merge commit in public branches. Prefer `git rebase` to get new commits from develop to local feature.
* **DO NOT** submit "work in progress" PRs.  A PR should only be submitted when it is considered ready for review and subsequent merging by the contributor.
* **DO NOT** mix independent, unrelated changes in one PR. Separate unrelated fixes into separate PRs.
* **DO NOT** send PRs for style changes.
* **DO NOT** surprise us with big pull requests. Instead, file an issue and start a discussion so we can agree on a direction before you invest a large amount of time.
* **DO NOT** commit code that you didn't write. If you find code that you think is a good fit to add to GMLRVA, file an issue and start a discussion before proceeding.
* **DO NOT** submit PRs that alter licensing related files or headers. If you believe there's a problem with them, file an issue and we'll be happy to discuss it.