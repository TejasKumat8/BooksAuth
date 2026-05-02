import markdown
from fpdf import FPDF
import re

# Read Markdown
md_path = "C:/Users/kumat/.gemini/antigravity/brain/29cfa04c-b517-40f8-a57e-c448db837b4a/submission_doc.md"
with open(md_path, "r", encoding="utf-8") as f:
    md_text = f.read()

# Replace unicode characters with ASCII
md_text = md_text.replace("—", "-")
md_text = md_text.replace("│", "|")
md_text = md_text.replace("├──", "|--")
md_text = md_text.replace("└──", "`--")
md_text = md_text.replace("✅", "[x]")
md_text = md_text.replace("🚀", "->")
md_text = md_text.replace("👉", "->")
md_text = md_text.replace("📄", "-")
md_text = md_text.replace("────────────────", "----------------")

# Replace markdown image syntax with HTML img tags for FPDF
# ![caption](path) -> <img src="path" width="400">
md_text = re.sub(r'!\[([^\]]*)\]\(([^)]+)\)', r'<br><img src="\2" width="500"><br>', md_text)

# Convert Markdown to HTML
html_content = markdown.markdown(md_text, extensions=['tables'])

# FPDF has trouble with some HTML, simplify it
html_content = html_content.replace('<th>', '<td><b>').replace('</th>', '</b></td>')

# Initialize PDF
pdf = FPDF()
pdf.add_page()
pdf.set_font("Times", size=12)

try:
    pdf.write_html(html_content)
    pdf.output("C:/Users/kumat/.gemini/antigravity/scratch/library-management/Project_Submission.pdf")
    print("PDF generated successfully.")
except Exception as e:
    print(f"Error generating PDF: {e}")
