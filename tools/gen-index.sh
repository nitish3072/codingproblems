#!/bin/bash
# Regenerates INDEX.md -- a flat, alphabetical listing of every problem in src/.
# Run from the repo root:  bash tools/gen-index.sh
set -e
cd "$(dirname "$0")/.."

rows=$(find src -type f \( -name '*.java' -o -name '*.scala' \) | while read -r f; do
  base=$(basename "$f"); base=${base%.java}; base=${base%.scala}
  name=$(echo "$base" | sed -E 's/([a-z0-9])([A-Z])/\1 \2/g; s/([A-Z]+)([A-Z][a-z])/\1 \2/g')
  url=$(grep -m1 -oE 'https?://[^ *)]+' "$f" | head -1)
  link=""; [ -n "$url" ] && link="[link]($url)"
  printf '%s\t%s\t%s\n' "$name" "$f" "$link"
done | sort -f)

total=$(printf '%s\n' "$rows" | wc -l)

{
echo "# Problem Index"
echo
echo "$total solutions. Auto-generated -- regenerate with \`bash tools/gen-index.sh\` after adding problems."
echo "Search this file before starting a problem to see whether you have already done it."
echo
echo "## Solved more than once"
echo
printf '%s\n' "$rows" | cut -f1 | sort -f | uniq -di | while read -r dup; do
  paths=$(printf '%s\n' "$rows" | awk -F'\t' -v d="$dup" 'tolower($1)==tolower(d){printf "`%s` ", $2}')
  echo "- **$dup** -- $paths"
done
echo
echo "## All problems"
echo
echo "| Problem | File | Source |"
echo "|---|---|---|"
printf '%s\n' "$rows" | awk -F'\t' '{printf "| %s | `%s` | %s |\n", $1, $2, $3}'
} > INDEX.md

echo "INDEX.md written ($total solutions)"
