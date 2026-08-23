# codingproblems

Personal DSA practice. Plain Java (11) and a few Scala files, no build tool — every
solution is a self-contained class with a `main` you can run directly.

**Before starting a problem, search [INDEX.md](INDEX.md)** — it lists all 314 solutions
alphabetically with their source links, plus a "solved more than once" section.
Regenerate it after adding problems:

```bash
bash tools/gen-index.sh
```

## Layout

Top level is **by source**, one level down is **by topic or difficulty**.

| Path | What's in it |
|---|---|
| `src/leetcode/easy`, `medium` | LeetCode, by difficulty |
| `src/leetcode/practice_march2026` | Dated revision batch (Mar 2026) |
| `src/scaler/` | Scaler Academy course, by module (`dp1`–`dp4`, `graph1`, `searching_*`, `trees_1`, `two_pointers`, `backtracking_lab`) — left untouched, already organised |
| `src/educative/grokkingcodinginterview/` | Grokking the Coding Interview, by pattern (`slidingwindow`, `twopointer`, `mergeintervals`, `linkedlistreversal`, `kwaymerge`, `topkelements`, `twoheaps`, `subsets`, `modifiedbinarysearch`) |
| `src/gfg/` | GeeksforGeeks must-do list and assorted classics, by topic (`arrays`, `dp`, `linkedlist`) |
| `src/algoxpert/arrays/` | AlgoExpert |
| `src/euler/` | Project Euler (Scala) |
| `src/helpers/` | Shared utilities (`MinHeap`, `MaxHeap`) |

## Conventions

- Package name always mirrors the directory path.
- One problem per file; the class name matches the file name.
- Put the problem URL in a Javadoc comment at the top — `tools/gen-index.sh` picks it up
  as the source link in the index.
- A second, different attempt at a problem already in the same package gets a `V1` suffix
  on the older version (e.g. `EditDistance.java` / `EditDistanceV1.java`).

## Running one

```bash
javac -d out $(find src -name '*.java')
java -cp out leetcode.medium.SortColors
```
