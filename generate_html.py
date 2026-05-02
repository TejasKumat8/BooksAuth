import markdown
import os

md_path = "C:/Users/kumat/.gemini/antigravity/brain/29cfa04c-b517-40f8-a57e-c448db837b4a/submission_doc.md"
with open(md_path, "r", encoding="utf-8") as f:
    md_text = f.read()

# Make image paths absolute for the HTML so Chrome can render them
# Currently they are C:/Users/...
md_text = md_text.replace('C:/Users/', 'file:///C:/Users/')

html_content = markdown.markdown(md_text, extensions=['tables'])

html_template = f"""
<!DOCTYPE html>
<html>
<head>
    <style>
        body {{ font-family: Arial, sans-serif; line-height: 1.6; max-width: 800px; margin: 0 auto; padding: 20px; }}
        table {{ border-collapse: collapse; width: 100%; margin-bottom: 20px; }}
        th, td {{ border: 1px solid #ddd; padding: 8px; text-align: left; }}
        th {{ background-color: #f2f2f2; }}
        img {{ max-width: 100%; height: auto; display: block; margin: 10px 0; border: 1px solid #ccc; }}
        pre {{ background-color: #f4f4f4; padding: 10px; border-radius: 5px; overflow-x: auto; }}
        code {{ font-family: Consolas, monospace; background-color: #f4f4f4; padding: 2px 4px; border-radius: 3px; }}
        h1, h2, h3 {{ color: #333; }}
        blockquote {{ border-left: 4px solid #ccc; margin: 0; padding-left: 10px; color: #666; }}
    </style>
</head>
<body>
{html_content}
</body>
</html>
"""

with open("C:/Users/kumat/.gemini/antigravity/scratch/library-management/submission.html", "w", encoding="utf-8") as f:
    f.write(html_template)
print("HTML generated successfully.")
